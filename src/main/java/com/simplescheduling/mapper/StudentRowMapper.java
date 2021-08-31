package com.simplescheduling.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.simplescheduling.beans.Student;

public class StudentRowMapper implements RowMapper<Student> {
	
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student student = new Student();
		student.setStudentId(rs.getInt("studentId"));
		student.setFirstname(rs.getString("firstname"));
		student.setLastname(rs.getString("lastname"));
		return student;

    }

}
