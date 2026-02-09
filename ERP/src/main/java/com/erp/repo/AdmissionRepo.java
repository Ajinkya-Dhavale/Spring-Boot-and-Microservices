package com.erp.repo;

import com.erp.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepo extends JpaRepository<Admission, Long> {

    boolean existsByAadharNo(String aadharNo);

    @Query("SELECT COALESCE(MAX(a.id), 0) FROM Admission a")
    Long findLastAdmissionId();
}
