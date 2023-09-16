package com.retsapis.blogging_application.repository;

import com.retsapis.blogging_application.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
