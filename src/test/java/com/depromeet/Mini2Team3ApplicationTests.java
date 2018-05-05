package com.depromeet;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.depromeet.member.service.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mini2Team3ApplicationTests {
	
	@Autowired
	private MemberService memberService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void loadData() {
		final String phone = "010-2824-8435";
		UserDetails userDetails = memberService.loadUserByUsername(phone);
		assertEquals(userDetails.getUsername(), phone);
	}
	
	@Test
	public void nullPassword() {
		Authentication auth = new UsernamePasswordAuthenticationToken(
			"010-2824-8435",
			null,
			Collections.emptyList()
		);
		System.out.println(auth.getCredentials().toString());
//		NoOpPasswordEncoder.getInstance().matches(presentedPassword, userDetails.getPassword()
	}
}
