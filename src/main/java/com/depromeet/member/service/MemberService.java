package com.depromeet.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.depromeet.member.entity.Member;
import com.depromeet.member.repository.MemberRepository;

@Service
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails userDetails =
				memberRepository.findByPhone(username);
		if (userDetails == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return userDetails;
	}
	
	public Member loadMemberByPhone(String phone) {
		return memberRepository.findByPhone(phone);
	}
}
