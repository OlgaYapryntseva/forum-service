package telran.java48.account.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	String login;
	String password;
	@Setter
	String firstName;
	@Setter
	String lastName;
	Set<String> role;
}
