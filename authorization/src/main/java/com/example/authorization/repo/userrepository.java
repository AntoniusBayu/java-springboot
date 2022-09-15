package com.example.authorization.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authorization.model.vwuser;

@Repository
public interface userrepository extends JpaRepository<vwuser, Long> {
	vwuser findByUsername(String username);
}
