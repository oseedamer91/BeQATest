package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
 	
    private String objectType;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private int countryId;
    private String externalId;
 

}
