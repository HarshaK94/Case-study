package com.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shared.model.LoggedInUserInfo;

public interface UserAuditRepository extends JpaRepository<LoggedInUserInfo, Integer> {

}
