package com.revature.service;

import com.revature.pojo.UserStatus;

public interface UserStatusService {

	public void addComments(int userCommentsId, String userCommentsValue, UserStatus userStatus);

	public void deleteComments(int userCommentsId, UserStatus userStatus);

	public int getNumberComments(UserStatus userStatus);

}
