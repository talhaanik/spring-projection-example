package com.example.demoprojection;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    Office office;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    @JsonManagedReference
    Set<Section> sectionList = new HashSet<>();

    public void setSectionList(Set<Section> sectionList) {
        this.sectionList = sectionList;
              /*  .stream()
                .map(o -> {
                    o.setDepartment(this);
                    return o;
                })
                .collect(Collectors.toSet());*/

        for (Section s:sectionList){
            s.setDepartment(this);
        }
    }


}
