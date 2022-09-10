package com.asbnotebook.example;

import com.asbnotebook.example.model.Student;
import com.asbnotebook.example.model.Students;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestPropertySource("/application.yml")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootDatabaseIntegrationTestExampleApplicationTests {
	@LocalServerPort
	private int port;
	String baseUrl = "http://localhost:";
	@Autowired
	JdbcTemplate jdbcTemplate;
	RestTemplate restTemplate;

	@BeforeEach
	void setup() {
		restTemplate = new RestTemplate();
		baseUrl = baseUrl + port;
		log.info("application started with base URL:{} and port:{}", baseUrl, port);
		log.info("Initializing DB..");
		jdbcTemplate.execute("insert into Student(name, grade) values('Jay', 7)");
	}

	@Test
	@DisplayName("Test Get All available Students")
	@Sql(scripts = "classpath:/initialize-data.sql")
	void testGetStudents() {
		ResponseEntity<Students> students = restTemplate.getForEntity((baseUrl + "/get-students"),
				Students.class);
		assertAll(
				() -> assertNotNull(students.getBody()),
				() -> assertNotNull(students.getBody().getStudents()),
				() -> assertEquals(students.getBody().getStudents().size(), 3),
				() -> assertTrue(students.getBody().getStudents().stream()
						.anyMatch(s -> s.getName().equals("Jay")))
		);
	}

	@DisplayName("Test get student by name")
	@Test
	void testGetStudentByName() {
		Student student =
				restTemplate.getForObject((baseUrl + "/get-student?name=Jay"), Student.class);
		assertAll(
				() -> assertNotNull(student),
				() -> assertEquals(student.getName(), "Jay")
		);
	}

	@AfterEach
	void emptyData(){
		var totalRecords = jdbcTemplate.queryForObject("Select count(*) from Student", Integer.class);
		log.info("Total Records in DB:{}", totalRecords);
		log.info("Deleting records from table.");
		jdbcTemplate.execute("DELETE FROM Student");
	}
}
