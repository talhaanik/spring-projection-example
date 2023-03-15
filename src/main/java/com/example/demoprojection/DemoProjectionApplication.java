package com.example.demoprojection;

import com.example.demoprojection.projections.SectionView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class DemoProjectionApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoProjectionApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoProjectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(OfficeRepo repository,SectionRepo sectionRepo,EmployeeRepo empRepo) {
		return (args) -> {
			// save a few customers
			Section section=new Section();
			section.setName("HRMS");

			Department department=new Department();
			department.setName("ICT");
			department.setSectionList(Set.of(section));

			Office office=new Office();
			office.setName("WDTL");
			office.setDepartmentList(Set.of(department));


			repository.save(office);


			// fetch all customers
			log.info("Section found with findAll():");
			log.info("-------------------------------");
			for (Section section1 : sectionRepo.findAll()) {
				log.info(section1.getName());
				empRepo.save(new Employee(null,"Talha",section1));

			//	log.info(section1.getDepartment().getName());
			}
			log.info("");
			log.info("Section found with findCustom():");
			log.info("-------------------------------");
			for (SectionView section1 : sectionRepo.findCustom()) {
				log.info(section1.getName());
			//	log.info(section1.getDepartment().getName());
			}
			log.info("");

			log.info("");
		};
	}

}
