package com.avangenio.firstex.Controller;


import com.avangenio.firstex.Entities.Section;
import com.avangenio.firstex.Services.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestAPISection {

    @Autowired
    SectionService sectionService;

    @RequestMapping(value = "/add/section",method = RequestMethod.POST)
    public Boolean addSection(Section section) {
        sectionService.saveOrUpdate(section);
        return true;
    }

    @RequestMapping(value = "/edit/section",method = RequestMethod.POST)
    public Boolean editSection(Section section) {
        Section section2 = section;
        sectionService.delete(section.getId());
        sectionService.saveOrUpdate(section2);
        return true;
    }

    @RequestMapping(value = "/rem/section",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public Boolean delSection(Section section) {
        sectionService.delete(section.getId());
        return true;
    }
}
