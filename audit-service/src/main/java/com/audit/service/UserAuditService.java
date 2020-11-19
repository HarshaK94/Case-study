package com.audit.service;

import java.util.List;

import com.shared.model.LoggedInUserInfo;

public interface UserAuditService {

	public List<LoggedInUserInfo> getList();
}
