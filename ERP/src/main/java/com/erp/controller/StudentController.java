package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@GetMapping({ "/", "" })
	public String getStudentAdminPannel() {
		return "Student/index.html";
	}

	@GetMapping({ "/personal_details", "/personal_details/" })
	public String getPersonal_details() {
		return "Student/personal_details";
	}

	@GetMapping({ "/address", "/address/" })
	public String getAddress() {
		return "Student/address";
	}
	
	@GetMapping({ "/academic_details", "/academic_details/" })
	public String getAcademicDetails() {
		return "Student/academic_details";
	}
	
	@GetMapping({ "/photo_sign", "/photo_sign/" })
	public String getPhotoAnsSign() {
		return "Student/photo_sign";
	}
}
