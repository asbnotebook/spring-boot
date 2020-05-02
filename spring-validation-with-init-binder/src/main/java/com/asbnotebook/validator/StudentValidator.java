package com.asbnotebook.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.asbnotebook.dto.Student;

@Component
public class StudentValidator implements Validator {

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Student student = (Student) target;
		ValidationUtils.rejectIfEmpty(errors, "name",
				messageSource.getMessage("student.name.error", null, Locale.getDefault()));
		if (student.getGrade() <= 0) {
			errors.rejectValue("grade", messageSource.getMessage("student.grade.error", null, Locale.getDefault()),
					"Student grade should be greater than zero");
		}
		if (null != student.getAddress() && Boolean.TRUE.equals(student.getAddress())
				&& null == student.getAddressDetails()) {
			errors.rejectValue("address", messageSource.getMessage("student.address.error", null, Locale.getDefault()),
					"Student address details should be empty");
		}
	}
}
