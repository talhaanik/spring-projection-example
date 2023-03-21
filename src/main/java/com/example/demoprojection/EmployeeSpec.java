package com.example.demoprojection;

import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpec {
    public static Specification<Employee> getEmployeesByName(String nickname) {

        return (root, query, criteriaBuilder) -> {

            return criteriaBuilder.equal(root.get("name"), nickname);

        };

    }
}
