package com.asbnotebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutoCompleteController {

	@GetMapping("/")
	public String home(Model model) {
		List<String> names = new ArrayList<>();
		names.add("Arun");
		names.add("Akhil");
		names.add("Anju");
		names.add("Aman");
		model.addAttribute("names", names);
		return "home";
	}
}