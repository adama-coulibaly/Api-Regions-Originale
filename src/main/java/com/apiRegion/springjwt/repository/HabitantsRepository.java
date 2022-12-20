package com.apiRegion.springjwt.repository;

import com.apiRegion.springjwt.models.Habitants;
import com.apiRegion.springjwt.models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HabitantsRepository extends JpaRepository<Habitants, Long> {


   // List<Habitants> findByRegions(Long id_regions);
}
