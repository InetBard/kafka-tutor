package ca.inetbard.springbootkafka.model;

import lombok.Data;

@Data
public class User {
	
	private long id;
	private String firstName;
	private String lastName;

}
