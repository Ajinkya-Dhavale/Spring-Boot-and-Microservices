package com.ajinkya.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.binding.AuthenticateRequest;
import com.ajinkya.entity.UserEntity;
import com.ajinkya.repo.UserRepo;
import com.ajinkya.service.JwtService;
import com.ajinkya.service.MyUserDetailService;


@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private MyUserDetailService service;
	
	@Autowired
	private UserRepo crepo;

	@Autowired
	private PasswordEncoder pwdEncoder;

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwt;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome ";
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody AuthenticateRequest c) {
		
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(c.getUserName(), c.getPassword());

		try {
			Authentication authenticate = authManager.authenticate(token);

			if (authenticate.isAuthenticated()) {
				String jwtToken = jwt.generateToken(c.getUserName());
				return new ResponseEntity<>("token : "+jwtToken, HttpStatus.OK);
			}

		} catch (Exception e) {
			//logger
		}

		return new ResponseEntity<String>("Invalid Credentials", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/register")
	public String registerCustomer(@RequestBody UserEntity customer) {
		
		// duplicate check

		String encodedPwd = pwdEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPwd);

		crepo.save(customer);

		return "User registered";
	}
}
