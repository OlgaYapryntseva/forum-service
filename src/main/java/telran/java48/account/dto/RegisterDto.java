package telran.java48.account.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter

public class RegisterDto {
  @NotBlank
  String login;
  
  @NotBlank
  String password;
  
  @NotBlank
  String firstName;
  
  @NotBlank
  String lastName;
}
