package com.cognizant.ormlearn;

import java.sql.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class Handson1OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Handson1OrmLearnApplication.class);

	public static EmployeeService employeeService;
	public static DepartmentService departmentService;
	public static SkillService skillService;

	public static void testGetEmployee() {
		LOGGER.info("----Start----");
		Employee employee = employeeService.get(6);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("----End----");
	}

	public static void testAddEmployee() {
		LOGGER.info("----Adding Employee----");
		Employee employee = new Employee();
		employee.setName("Sunil");
		employee.setSalary(12000);
		employee.setPermanent(true);
		employee.setDateOfBirth(Date.valueOf("1999-01-13"));
		Department department = departmentService.get(2);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("----Employee Added----");
	}

	public static void testUpdateEmployee() {
		LOGGER.info("----Updating Employee----");
		Employee employee = employeeService.get(3);
		Department department = departmentService.get(4);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("----Employee Updated----");
	}

	public static void testGetDepartment() {
		LOGGER.info("----Start----");
		Department department = departmentService.get(2);
		LOGGER.debug("Department:{}", department);
		Set<Employee> employees = department.getEmployeeList();
		LOGGER.debug("Employee List:{}", employees);
		LOGGER.info("----End----");
	}

	public static void testAddSkillToEmployee() {
		LOGGER.info("----Adding Skill to Employee----");
		Employee employee = employeeService.get(6);
		Skill skill = skillService.get(1);
		Skill skill1 = skillService.get(2);
		employee.getSkillList().add(skill);
		employee.getSkillList().add(skill1);
		employeeService.save(employee);
		LOGGER.info("----Skill Added to Employee----");
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1OrmLearnApplication.class, args);

		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
		// testAddEmployee();
		// testGetEmployee();
		testAddSkillToEmployee();
		testGetEmployee();
	}
}
