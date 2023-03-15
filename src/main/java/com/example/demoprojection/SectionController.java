package com.example.demoprojection;

import com.example.demoprojection.projections.SectionPj;
import com.example.demoprojection.projections.SectionView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class SectionController {
    private final SectionRepo sectionRepo;
    private final OfficeRepo officeRepo;
    private final EmployeeRepo empRepo;

    @GetMapping("/section/show")
    public List<SectionView> show(){
        return sectionRepo.findAllByName("HRMS");
    }
    @GetMapping("/section/show-all")
    public List<Section> showAll(){
        return sectionRepo.findAll();
    }
    @GetMapping("/office/show-all")
    public List<Office> showAllOffice(){
        return officeRepo.findAll();
    }

    @GetMapping("/emp/show-all")
    public List<Employee> empshow(){

        return empRepo.findAllProjectdBy();
    }

}
