package com.example.demoprojection;

import com.example.demoprojection.projections.SectionPj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findAllProjectdBy();
}
