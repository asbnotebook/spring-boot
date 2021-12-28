package com.asb.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxCalculatorController {

	@Autowired
	private TaxCalculatorService taxCalculatorService;

	@GetMapping("/calculateTax")
	public ResponseEntity<IncomeDetails> getIncomeTax(@RequestParam(required = true, name = "income") Integer income) {
		IncomeDetails incomeObj = new IncomeDetails();
		incomeObj.setIncomeInRupees(income);
		return new ResponseEntity<IncomeDetails>(taxCalculatorService.calculateIncomeTax(incomeObj), HttpStatus.OK);
	}
}