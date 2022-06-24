package com.sdd.absensi.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPasswordEncoder implements PasswordEncoder {
	 
	private String encryptPassword = "lqzspllpFF2cq4KjMzjFS5RzwftwutpvGIbngDHvaqY=";
	
	@Override
	public String encode(CharSequence rawPassword) {
		rawPassword = encryptPassword+rawPassword;
		String hashed = BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
	    return hashed;
	}
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		rawPassword = encryptPassword+rawPassword;
		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}
}
