package com.avangenio.firstex.Repositories;

import com.avangenio.firstex.Entities.Section;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<Section, Integer>{}

