package model.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.RestService;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser extends RestService {
	
	private String apiVersion;
	private int partnerId;
	private String username;
	private String password;
	private Object extraParams;
	


}
