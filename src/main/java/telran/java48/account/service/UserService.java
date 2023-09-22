package telran.java48.account.service;

import telran.java48.account.dto.RegisterDto;
import telran.java48.account.dto.RoleDto;
import telran.java48.account.dto.UpdateDto;
import telran.java48.account.dto.UserDto;
import telran.java48.account.dto.exceptions.UserExistsException;


public interface UserService {
    UserDto registerUser(RegisterDto registerDto) throws UserExistsException;
    
    UserDto loginUser(String token);
    
    UserDto deleteUser(String login);
    
    UserDto updateUser(String login, UpdateDto updateDto);
    
    RoleDto addRole(String login, String role);
    
    RoleDto deleteRole(String login,String role);
    
    UserDto findUser(String login);
    
	void changePassword(String login, String newPassword);
    
}
