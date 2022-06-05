package com.cysbersoft.createstudentcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cysbersoft.createstudentcontroller.pojo.Student;

@RestController
@RequestMapping("/student")
public class AcountController {

	public List<Student> listStudent = new ArrayList<Student>();
	
		@RequestMapping(value="/student", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<List<Student>> index(@RequestParam String name, @RequestParam int age) {
			
			listStudent.add(new Student(name,age));
			//return listStudent;
			
			return new ResponseEntity<List<Student>>(listStudent, HttpStatus.OK);
		}
		
		

		@RequestMapping(value="/student", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<List<Student>> index1(@PathVariable("name") String name, @PathVariable("age") int age) {
			
			/*
			 * Student student = new Student(); student.setName(name); student.setAge(age);
			 * // chuyển object thành json ObjectMapper om = new ObjectMapper(); String json
			 * = om.writeValueAsString(student);
			 */
			
			listStudent.add(new Student(name,age));
			return new ResponseEntity<List<Student>>(listStudent, HttpStatus.OK);
		}
		
		
		@RequestMapping(value="/student", method = RequestMethod.POST, consumes="application/json")
		@ResponseBody
		public ResponseEntity<List<Student>> index2(@RequestBody Student student) {
			
			Student enity = new Student();
			enity.setName(student.getName());
			
			enity.setAge(student.getAge());
			
			listStudent.add(enity);
			return new ResponseEntity<List<Student>>(listStudent, HttpStatus.OK);
		}
}
