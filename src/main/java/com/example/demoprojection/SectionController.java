package com.example.demoprojection;

import com.example.demoprojection.projections.SectionView;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class SectionController {
    private final SectionRepo sectionRepo;
    private final OfficeRepo officeRepo;
    private final EmployeeExtRepo empRepo;

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
    public String empshow(){

        List<Tuple> allProjectdBy = empRepo.findAllWithPagination(EmployeeSpec.getEmployeesByName("Talha"),
                Pageable.ofSize(5), Arrays.asList("name","id"));

for(Tuple tupl:allProjectdBy){
    log.info(tupl.get(0).toString());
}
        return "done";
    }

}
