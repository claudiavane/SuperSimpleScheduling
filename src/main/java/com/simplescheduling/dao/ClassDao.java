package com.simplescheduling.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplescheduling.beans.Materia;
import com.simplescheduling.beans.Student;
import com.simplescheduling.mapper.ClassRowMapper;

public class ClassDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Materia cl){  
	    String sql="insert into class(code,title,description) values('"+cl.getCode()+"','"+cl.getTitle()+"','"+cl.getDescription()+"')";  
	    return template.update(sql);  
	}  
	public int update(Materia cl){  
	    String sql="update class set title='"+cl.getTitle()+"', description='"+cl.getDescription()+"' where code='"+cl.getCode()+"'";  
	    return template.update(sql);  
	}  
	public int delete(String code){  
	    String sql="delete from class where code='"+code+"'"; 
	    return template.update(sql);  
	}  
	public Materia getMateriaByCode(String code){  
	    String sql="select * from class where code=?";  
	    
	    return template.queryForObject(sql, new Object[]{code}, new ClassRowMapper());
	}  
	public List<Materia> getClassList(){  
	    return template.query("select * from class",new RowMapper<Materia>(){  
	        public Materia mapRow(ResultSet rs, int row) throws SQLException {  
	        	Materia e=new Materia();  
	            e.setCode(rs.getString(1));  
	            e.setTitle(rs.getString(2));  
	            e.setDescription(rs.getString(3)); 
	            return e;  
	        }  
	    });  
	}
	
	public List<Student> getStudentsAssigned(String classCode){  
		String sql="SELECT s.* FROM student s, class_student cs WHERE s.studentId = cs.studentId AND cs.classCode='"+classCode+"'"; 
		
	    return template.query(sql,new RowMapper<Student>(){  
	    	
	        public Student mapRow(ResultSet rs, int row) throws SQLException {  
	        	Student e=new Student();  
	            e.setStudentId(rs.getInt(1));  
	            e.setFirstname(rs.getString(2));  
	            e.setLastname(rs.getString(3)); 
	            return e;  
	        }  
	    });  
	} 

}
