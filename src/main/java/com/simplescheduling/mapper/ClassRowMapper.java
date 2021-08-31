package com.simplescheduling.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.simplescheduling.beans.Materia;

public class ClassRowMapper implements RowMapper<Materia> {
	
	public Materia mapRow(ResultSet rs, int rowNum) throws SQLException {

		Materia materia = new Materia();
		materia.setCode(rs.getString("code"));
		materia.setTitle(rs.getString("title"));
		materia.setDescription(rs.getString("description"));
		return materia;

    }

}
