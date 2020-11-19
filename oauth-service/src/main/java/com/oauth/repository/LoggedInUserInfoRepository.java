package com.oauth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shared.model.LoggedInUserInfo;

public interface LoggedInUserInfoRepository extends JpaRepository<LoggedInUserInfo, Integer>{

	@Query(value = "from LoggedInUserInfo where username=?1")
	public List<LoggedInUserInfo> getListByUsername(String username);
}
