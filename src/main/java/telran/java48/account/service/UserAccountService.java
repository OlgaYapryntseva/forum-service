package telran.java48.account.service;

import telran.java48.account.dto.RolesDto;
import telran.java48.account.dto.UserDto;
import telran.java48.account.dto.UserEditDto;
import telran.java48.account.dto.UserRegisterDto;

public interface UserAccountService {

	UserDto register(UserRegisterDto userRegisterDto);

	UserDto getUser(String login);

	UserDto removeUser(String login);

	UserDto updateUser(String login, UserEditDto userEditDto);

	RolesDto changeRolesList(String login, String role, boolean isAddRole);

	void changePassword(String login, String newPassword);

}
