package com.asb.example.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HighChartController {

	@GetMapping("/get-data")
	public ResponseEntity<Map<String, Integer>> getPieChart() {
		Map<String, Integer> graphData = new TreeMap<>();
		graphData.put("2016", 147);
		graphData.put("2017", 1256);
		graphData.put("2018", 3856);
		graphData.put("2019", 19807);
		return new ResponseEntity<>(graphData, HttpStatus.OK);
	}
}