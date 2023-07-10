package com.fhb.web.repositories;

import com.fhb.web.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long > {
    Role findByName(String name);

}
