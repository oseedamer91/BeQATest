package model.register;

import lombok.Data;
import model.User;
import service.RestService;


@Data
public class RegisterUser extends RestService {
	private String apiVersion;
	private int partnerId;
	private User user;
	private String password;
	
	
	

}
