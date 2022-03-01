package com.avangenio.firstex.Controller;

import com.avangenio.firstex.Entities.ProductType;
import com.avangenio.firstex.Entities.Section;
import com.avangenio.firstex.Payload.Response.MessageResponse;
import com.avangenio.firstex.Services.SectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestAPISection {

    @Autowired
    SectionService sectionService;

    @RequestMapping(value = "/list/section/{id}", method = RequestMethod.POST)
    public Section addSection(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }

    @RequestMapping(value = "/add/section", method = RequestMethod.POST)
    public ResponseEntity<?> addSection(Section sectionRequest) {

        if (sectionRepository.existsByUsername(sectionRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        // Create new user's account
        Section section = new User(sectionRequest.getUsername(),
        sectionRequest.getEmail(),
                encoder.encode(sectionRequest.getPassword()));
        Set<String> strRoles = sectionRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Section userRole = sectionRepository.findByName(ProductType.)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    default:
                    Role opRole = roleRepository.findByName(ERole.ROLE_OPERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(opRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

        sectionService.saveOrUpdate(section);
        return ResponseEntity.ok(new MessageResponse("Product added successfully!"));
    }

    @RequestMapping(value = "/edit/section", method = RequestMethod.POST)
    public Boolean editSection(Section section) {
        Section section2 = section;
        sectionService.delete(section.getId());
        sectionService.saveOrUpdate(section2);
        return true;
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
