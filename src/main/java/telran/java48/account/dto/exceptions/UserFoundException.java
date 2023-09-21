package telran.java48.account.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class UserFoundException extends RuntimeException{
	private static final long serialVersionUID = 5378082918253424019L;

}
