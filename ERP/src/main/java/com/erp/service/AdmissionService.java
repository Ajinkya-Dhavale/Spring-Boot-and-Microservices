package com.erp.service;

import com.erp.entity.Admission;
import com.erp.repo.AdmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepo admissionRepository;

    public boolean checkAdmissionByAadhar(String aadharNumber) {
        return admissionRepository.existsByAadharNo(aadharNumber);
    }

    public Admission saveAdmission(Admission admission) {
        // Fetch the last admissionId
        Long lastAdmissionId = admissionRepository.findLastAdmissionId();
        Long newAdmissionId = (lastAdmissionId != null) ? lastAdmissionId + 1 : 1;

        // Generate admission_generated_id
        String generatedId = generateAdmissionId(newAdmissionId);
        admission.setAdmissionId(generatedId); // Ensure it's saved in the correct field

        System.out.println("Last Admission ID: " + lastAdmissionId);
        System.out.println("New Admission ID: " + newAdmissionId);
        System.out.println("Generated ID: " + generatedId);
        System.out.println("Saving Admission: " + admission);

        // Save admission
        return admissionRepository.save(admission);
    }

    private String generateAdmissionId(Long admissionId) {
        int currentYear = LocalDate.now().getYear();
        return currentYear + String.format("%04d", admissionId); // Format: "202500001"
    }
    
    
    public List<Admission> getAllStudents() {
        return admissionRepository.findAll(); // Fetch all student records
    }
}
