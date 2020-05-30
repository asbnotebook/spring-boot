package com.asbnotebook.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String getAllEmployees(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "home";
	}

	@GetMapping("/create")
	public String createEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("isUpdate", false);
		return "create-update";
	}

	@GetMapping("/update/{id}")
	public String updateEmployeePage(Model model, @PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmployee(id);
		model.addAttribute("employee", employee);
		model.addAttribute("isUpdate", true);
		return "create-update";
	}

	@PostMapping("/update/{id}")
	public String createEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") Integer id) {
		employeeService.updateEmployee(employee, id);
		return "redirect:/";
	}

	@PostMapping("/create")
	public String createEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.createEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}