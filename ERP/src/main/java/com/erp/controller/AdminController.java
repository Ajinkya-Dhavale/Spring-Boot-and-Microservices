package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.entity.Admission;
import com.erp.service.AdmissionService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    private AdmissionService admissionService;

    @GetMapping({"/", ""})  
    public String getIndex(HttpSession session) {
        return "Admin/index";
    }

    @GetMapping({"/add_student","/add_student/"})
    public String openAddStudent(Model model) {
        Admission admission = new Admission();
        model.addAttribute("admission", admission);
        return "Admin/add_student";
    }

    @GetMapping({"/view_student","/view_student/"})
    public String openViewStudent(Model model) {
    	
    	List<Admission> admissions_list=admissionService.getAllStudents();
    	model.addAttribute("admission_list",admissions_list);   	
    	
        return "Admin/view_student";
    }

    @PostMapping("/admission")
    public String takeAdmission(@ModelAttribute("admission") Admission admission, RedirectAttributes redirectAttributes) {
        System.out.println("Received Admission: " + admission);

        // Check if Aadhar number already exists
        if (admissionService.checkAdmissionByAadhar(admission.getAadharNo())) {
            redirectAttributes.addFlashAttribute("error", "Aadhar already exist..!");
            return "redirect:/admin/add_student";
        }

        // Save the admission
        Admission savedAdmission = admissionService.saveAdmission(admission);

        // Success message
        redirectAttributes.addFlashAttribute("success", "Admission Done..!");

        return "redirect:/admin/add_student";
    }
    
}
