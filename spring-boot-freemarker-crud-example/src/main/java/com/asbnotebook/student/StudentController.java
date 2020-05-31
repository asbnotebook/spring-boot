package com.asbnotebook.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "home";
	}

	@GetMapping("/create")
	public String createStudentPage(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("isUpdate", false);
		return "create-update";
	}

	@GetMapping("/update/{id}")
	public String updateStudentPage(Model model, @PathVariable("id") Integer id) {
		Student student = studentService.getStudent(id);
		model.addAttribute("student", student);
		model.addAttribute("isUpdate", true);
		return "create-update";
	}

	@PostMapping("/update/{id}")
	public String createStudent(@ModelAttribute("student") Student student, @PathVariable("id") Integer id) {
		studentService.updateStudent(student, id);
		return "redirect:/";
	}

	@PostMapping("/create")
	public String createStudent(@ModelAttribute("student") Student student) {
		studentService.createStudent(student);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
		return "redirect:/";
	}
}