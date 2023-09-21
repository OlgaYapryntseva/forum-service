package telran.java48.account.model;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "login")
@Document(collection = "account")
@ToString
public class User {
	@Id
	String login;
	String password;
	@Setter
	String firstName;
	@Setter
	String lastName;
	Set<String> role;

	
	public User() {
		role = new HashSet<>();
	}
	
	public void removeRole(String roles) {
		role.remove(roles);
	}

	public void addRole(String newrole) {
		role.add(newrole);
	}


}
