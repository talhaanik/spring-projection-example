package com.example.demoprojection;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    @JsonManagedReference
    Set<Department> departmentList = new HashSet<>();

    public void setDepartmentList(Set<Department> departmentList) {
        this.departmentList = departmentList;
               /* .stream()
                .map(o -> {
                    o.setOffice(this);
                    return o;
                })
                .collect(Collectors.toSet());*/
        for(Department d:departmentList){
            d.setOffice(this);
        }
    }

    @Override
    public String toString() {
        return "Office{" +
                "name='" + name + '\'' +
                '}';
    }
}
