package com.depromeet.member.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	public Optional<Member> loadMemberByToken() {
		String phone = SecurityContextHolder.getContext()
				.getAuthentication()
				.getName();
		
		return Optional.ofNullable(memberRepository.findByPhone(phone));
	}
	
	public Optional<Member> loadMemberByPhone(String phone) {
		return Optional.ofNullable(memberRepository.findByPhone(phone));
	}
	
	public void updateJoinedStudy(Long memberId, Long studyId) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new NoSuchElementException("회원 정보가 유효하지 않습니다."));
		
		if (member.getJoinedStudyId() != studyId) {
			member.setJoinedStudyId(studyId);
			memberRepository.save(member);
		}
	}
}
