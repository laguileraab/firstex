package com.avangenio.firstex.Controller;

import com.avangenio.firstex.Entities.Section;
import com.avangenio.firstex.Payload.Response.MessageResponse;
import com.avangenio.firstex.Services.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestAPISection {

    @Autowired
    SectionService sectionService;

    @RequestMapping(value = "/list/section/{id}", method = RequestMethod.POST)
    public Section addSection(@PathVariable int id) {
        return sectionService.getSectionById(id);
    }

    @PostMapping(value = "/add/section")
    public ResponseEntity<?> addSection(@RequestBody Section section) {
        sectionService.saveOrUpdate(section);
        return ResponseEntity.ok(new MessageResponse("Section added successfully!"));
    }

    @RequestMapping(value = "/edit/section/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> editSection(@RequestBody Section section,@PathVariable int id) {
        if(sectionService.getSectionById(id) == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Section not found!"));
        }
        sectionService.delete(id);
        sectionService.saveOrUpdate(section);
        return ResponseEntity.ok(new MessageResponse("Section added successfully!"));
    }

    @RequestMapping(value = "/rem/section", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public Boolean delSection(Section section) {
        if (section.getProducts().isEmpty()){
            sectionService.delete(section.getId());
        }else{
            return false;
        }
        return true;
    }
}
