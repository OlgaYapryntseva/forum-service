package telran.java48.account.controller;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import telran.java48.account.dto.RegisterDto;
import telran.java48.account.dto.RoleDto;
import telran.java48.account.dto.UpdateDto;
import telran.java48.account.dto.UserDto;
import telran.java48.account.dto.exceptions.UserFoundException;
import telran.java48.account.server.UserServer;


@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class UserController {
	
	final UserServer userServer;
	
	@PostMapping("/register")
	public UserDto registerUser(@Valid @RequestBody RegisterDto registerDto) throws UserFoundException{
		return userServer.registerUser(registerDto);
	}

	@PostMapping("/login")
	public UserDto loginUser(@RequestHeader("Authorization") String token) {
		return userServer.loginUser(token);
	}

	@DeleteMapping("/user/{user}")
	public UserDto deleteUser(@PathVariable String user) {
		return userServer.deleteUser(user);
	}

	@PutMapping("/user/{user}")
	public UserDto updateUser(@PathVariable String user,@RequestBody UpdateDto updateDto) {
		return userServer.updateUser(user, updateDto);
	}

	@PutMapping("/user/{user}/role/{role}")
	public RoleDto addRole(@PathVariable String user,@PathVariable String role) {
		return userServer.addRole(user, role);
	}

	@DeleteMapping("/user/{user}/role/{role}")
	public RoleDto deleteRole(@PathVariable String user,@PathVariable String role) {
		return userServer.deleteRole(user, role);
	}

	@GetMapping("/user/{user}")
	public UserDto findUser(@PathVariable String user) {
		return userServer.findUser(user);
	}
     
	@PutMapping("/password")
	public void changePassword(@RequestHeader("X-Password") String newPassword) {
		userServer.changePassword(newPassword);
    }
	
	
}
