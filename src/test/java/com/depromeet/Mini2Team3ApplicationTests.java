package com.depromeet;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.depromeet.member.service.MemberService;
import com.depromeet.schedule.dto.AttendanceDto;
import com.depromeet.schedule.service.ScheduleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mini2Team3ApplicationTests {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ScheduleService scheduleService;

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
	
	@Test
	public void weekOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.WEEK_OF_MONTH, 3);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DATE));
	}
	
	@Test
	public void decideAttendance() {
		List<AttendanceDto> attendances = new ArrayList<>();
		
		AttendanceDto a1 = new AttendanceDto();
		a1.setMemberId(1L);
		a1.setAttendanceCode(1L);
		attendances.add(a1);
		
		AttendanceDto a2 = new AttendanceDto();
		a2.setMemberId(3L);
		a2.setAttendanceCode(3L);
		attendances.add(a2);
		
		scheduleService.decideAttendance(2L, attendances);
	}
}
