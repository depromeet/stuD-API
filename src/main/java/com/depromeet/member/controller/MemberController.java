package com.depromeet.member.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.common.dto.ApiResponse;
import com.depromeet.common.exception.UnauthorizedException;
import com.depromeet.member.dto.MemberDto;
import com.depromeet.member.entity.Member;
import com.depromeet.member.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/{memberId}")
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<MemberDto> loadMemberInfo(@PathVariable Long memberId) {
		Member member = memberService.loadMemberByToken()
				.orElseThrow(() -> new NoSuchElementException("회원 정보가 유효하지 않습니다."));
		
		if (member.getMemberId() != memberId) {
			throw new UnauthorizedException("권한이 없습니다.");
		}
		
		
	}
}
