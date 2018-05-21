package com.depromeet.study.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.schedule.entity.Study;

@Repository
public interface StudyRepository extends CrudRepository<Study, Long> {
	
	public List<Study> findByLeaderMemberId(Long leaderId);
}
