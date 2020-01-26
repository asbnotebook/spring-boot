package com.asb.example.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.asb.example.dto.EmailRequestDto;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Configuration configuration;

	public String sendMail(EmailRequestDto request, Map<String, String> model) {

		String response;
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			ClassPathResource pdf = new ClassPathResource("static/attachment.pdf");
			ClassPathResource image = new ClassPathResource("static/asbnotebook.png");
			Template template = configuration.getTemplate("email.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

			helper.setTo(request.getTo());
			helper.setFrom(request.getFrom());
			helper.setSubject(request.getSubject());
			helper.setText(html, true);
			helper.addInline("asbnotebook", image);
			helper.addAttachment("attachment.pdf", pdf);

			mailSender.send(message);
			response = "Email has been sent to :" + request.getTo();
		} catch (MessagingException | IOException | TemplateException e) {
			response = "Email send failure to :" + request.getTo();
		}
		return response;
	}
}