package com.mgcafemanagementsystem.mg.cafe.repository;

import com.mgcafemanagementsystem.mg.cafe.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(@Param("email") String email);
}
