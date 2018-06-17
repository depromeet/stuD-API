package com.depromeet.schedule.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.depromeet.schedule.dto.AttendanceId;
import com.depromeet.schedule.entity.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, AttendanceId> {
	
	public List<Attendance> findByScheduleScheduleIdIn(Iterable<Long> scheduleIds);
	
	public List<Attendance> findByScheduleScheduleId(Long scheduleId);
	
	public List<Attendance> findByMemberMemberId(Long memberId);
	
	public int countByMemberMemberIdAndAttendanceCode(
			Long memberId, Long attendanceCode);
}
