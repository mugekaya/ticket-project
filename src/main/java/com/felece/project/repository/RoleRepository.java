package com.felece.project.repository;

import com.felece.project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
} //long seklinde olana da kizdi, sadece Long