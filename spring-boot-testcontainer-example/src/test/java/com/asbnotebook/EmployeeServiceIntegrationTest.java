package com.asbnotebook;

import com.asbnotebook.controller.EmployeeDto;
import com.asbnotebook.repository.EmployeeRepository;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeServiceIntegrationTest extends BaseTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    EmployeeRepository employeeRepository;

    @AfterEach
    void clearRecordsFromDb() {
        employeeRepository.deleteAll();
    }

    @Test
    void testFindAllEmployees() {
        var employeeDto1 = EmployeeDto.builder().name("Arun").salary(20000).build();
        var employeeDto2 = EmployeeDto.builder().name("Raj").salary(10000).build();

        //Create employee details in DB:
        testRestTemplate.postForEntity("/employee", employeeDto1, EmployeeDto.class);
        testRestTemplate.postForEntity("/employee", employeeDto2, EmployeeDto.class);

        //fetch all employees:
        var response = testRestTemplate.getForEntity("/employees", String.class);

        //Verify response:
        var employeesResponseJSon = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();

        DocumentContext resp = JsonPath.parse(employeesResponseJSon);

        assertEquals(Optional.ofNullable(resp.read("$.length()")).get(), 2);

        assertEquals(Optional.ofNullable(resp.read("$[0].id")).get(), 1);
        assertEquals(Optional.ofNullable(resp.read("$[0].name")).get(), "Arun");
        assertEquals(Optional.ofNullable(resp.read("$[0].salary")).get(), 20000);

        assertEquals(Optional.ofNullable(resp.read("$[1].id")).get(), 2);
        assertEquals(Optional.ofNullable(resp.read("$[1].name")).get(), "Raj");
        assertEquals(Optional.ofNullable(resp.read("$[1].salary")).get(), 10000);
    }

    @Test
    void testDeleteEmployees() {
        //Create employee details in DB:
        var employeeDto1 = EmployeeDto.builder().name("Arun").salary(20000).build();
        var employee = testRestTemplate.postForEntity("/employee", employeeDto1, EmployeeDto.class).getBody();

        //fetch all employees:
        assertEquals(Optional.ofNullable(JsonPath.parse(testRestTemplate.getForEntity("/employees", String.class)
                .getBody()).read("$.length()")).get(), 1);

        //Delete record:
        testRestTemplate.delete("/employee/{id}", employee.getId());

        //fetch all employees:
        assertEquals(Optional.ofNullable(JsonPath.parse(testRestTemplate.getForEntity("/employees", String.class)
                .getBody()).read("$.length()")).get(), 0);
    }
}
