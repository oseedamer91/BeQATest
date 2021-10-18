package utils;

public enum EnumEndPoint{
	CREATE_USER_POST("https://api.frs1.ott.kaltura.com/api_v3/service/ottuser/action/register"),
	LOGIN_USER_POST("https://api.frs1.ott.kaltura.com/api_v3/service/ottuser/action/login")
	;
	
	private String value;
	
	
	EnumEndPoint(String url) {
		this.value = url;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}



	
	
}
