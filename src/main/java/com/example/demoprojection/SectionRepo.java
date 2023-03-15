package com.example.demoprojection;

import com.example.demoprojection.projections.SectionPj;
import com.example.demoprojection.projections.SectionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface SectionRepo extends JpaRepository<Section, Long> {
    List<SectionView> findAllByName(String name);

    @Query("select s from Section s join s.department")
    List<SectionView> findCustom();
}
