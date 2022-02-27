package com.avangenio.firstex.Repositories;

import java.util.Optional;

import com.avangenio.firstex.Models.ERole;
import com.avangenio.firstex.Models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}