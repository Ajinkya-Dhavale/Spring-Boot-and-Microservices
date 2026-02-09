package com.ajinkya.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dao")
@Primary
public class UerDAOImplSecond implements UserDAO {
		public UerDAOImplSecond() {
			System.out.println("UerDAOImplSecond.....");
		}
		@Override
		public String getUser() {
			System.out.println("second");
			return "Ajinkya";
		}
	}
