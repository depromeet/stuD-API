package com.depromeet.member.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.member.entity.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
	
	Member findByPhone(String phone);
}
