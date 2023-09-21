package telran.java48.account.server;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import telran.java48.account.dto.RegisterDto;
import telran.java48.account.dto.RoleDto;
import telran.java48.account.dto.UpdateDto;
import telran.java48.account.dto.UserDto;
import telran.java48.account.dto.exceptions.UserFoundException;
import telran.java48.account.dto.exceptions.UserNotFoundException;
import telran.java48.account.model.User;
import telran.java48.account.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserServerImpl implements UserServer{
	
	final UserRepository userRepository;
	final ModelMapper modelMapper;

	@Override
	public UserDto registerUser(RegisterDto registerDto) throws UserFoundException{
		if (userRepository.existsById(registerDto.getLogin())) {
     		throw new UserFoundException();
		}
		User user = modelMapper.map(registerDto, User.class);
		userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto loginUser(String token) {
//		System.out.println(token);
		return null;
	}

	@Override
	public UserDto deleteUser(String login) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException());
        userRepository.delete(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(String login, UpdateDto updateDto) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException());
		if(updateDto.getFirstName() != null) {
			user.setFirstName(updateDto.getFirstName());
		}
		if(updateDto.getLastName() != null) {
			user.setLastName(updateDto.getLastName());
		}
		userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public RoleDto addRole(String login, String role) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException());
		user.addRole(role);
		userRepository.save(user);
		return modelMapper.map(user, RoleDto.class);
	}

	@Override
	public RoleDto deleteRole(String login, String role) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException());
		user.removeRole(role);
		userRepository.save(user);
		return modelMapper.map(user, RoleDto.class);
	}

	@Override
	public UserDto findUser(String login) {
		User user = userRepository.findById(login).orElseThrow(() -> new UserNotFoundException());
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public void changePassword(String newPassword) {
		System.out.println("Metod changePassword = " +  newPassword);
		// TODO Auto-generated method stub
		
	}
}
