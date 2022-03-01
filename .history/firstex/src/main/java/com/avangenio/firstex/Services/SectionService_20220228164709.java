package com.avangenio.firstex.Services;

import java.util.ArrayList;
import java.util.List;

import com.avangenio.firstex.Entities.Section;
import com.avangenio.firstex.Repositories.SectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService
{
    @Autowired
    SectionRepository sectionRepository;

    public List<Section> getAllSections()
    {
        List<Section> sections = new ArrayList<Section>();
        sectionRepository.findAll().forEach(section -> sections.add(section));
        return sections;
    }
    
    public Section getSectionById(int uuid)
    {
        return sectionRepository.findById(uuid).get();
    }
    
    public void saveOrUpdate(Section section)
    {
        sectionRepository.save(section);
    }
    
    public void delete(Long long1)
    {
        sectionRepository.deleteById(long1);
    }

    public void deleteAll() {
        sectionRepository.deleteAll();
    }
}