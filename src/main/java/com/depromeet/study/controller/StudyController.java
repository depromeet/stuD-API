package com.depromeet.study.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.common.dto.ApiResponse;
import com.depromeet.member.entity.Member;
import com.depromeet.member.service.MemberService;

@RestController
@RequestMapping("/studies")
public class StudyController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/{studyId}/join")
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<Object> joinStudy(@PathVariable Long studyId) {
		Member member = memberService.loadMemberByToken()
				.orElseThrow(() -> new NoSuchElementException("회원 정보가 유효하지 않습니다."));
		
		memberService.updateJoinedStudy(member.getMemberId(), studyId);
		
		return new ApiResponse<>(memberService.isLeader());
	}
}
