package com.example.query;

import com.example.request.SampleRequestNames;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	StudentService studentService;

	public String firstQuery () {
		return "First Query";
	}
	public String secondQuery(){return "Adi's second query";}
	public String getFullName(SampleRequestNames srn){
		return srn.getFirstName()+" "+srn.getLastName();
	}

	public StudentResponse student(Long id){
	return new StudentResponse(studentService.getStudentById(id));
	}
}
