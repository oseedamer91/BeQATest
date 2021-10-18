package model;

import org.apache.http.Header;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {
	private String request;
	private Header[] headerResponse;
	private String bodyResponse;
	private String errMsg;

}
