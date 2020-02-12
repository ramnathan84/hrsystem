package com.demo.hrsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hrsystem.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
