package com.webapp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp3.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
