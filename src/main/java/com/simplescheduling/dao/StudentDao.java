package com.simplescheduling.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.simplescheduling.beans.Materia;
import com.simplescheduling.beans.Student;
import com.simplescheduling.mapper.StudentRowMapper;

public class StudentDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Student student){ 
		String sql="insert into student(firstname,lastname) values('"+student.getFirstname()+"','"+student.getLastname()+"')";  
	    
	    return template.update(sql);  
	}  
	public int update(Student student){  
	    String sql="update student set firstname='"+student.getFirstname()+"', lastname='"+student.getLastname()+"' where studentId="+student.getStudentId()+"";  
	    
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from student where studentId="+id+"";  
	    return template.update(sql);  
	}  

	public Student getStudentById(int id){  
	    String sql="select * from student where studentId=?";
	    Student student = new Student();
	    student = template.queryForObject(sql, new Object[]{id}, new StudentRowMapper());
	    
	    return student;  
	    
	}  
	public List<Student> getStudents(){  
	    return template.query("select * from student",new RowMapper<Student>(){  
	        public Student mapRow(ResultSet rs, int row) throws SQLException {  
	        	Student e=new Student();  
	            e.setStudentId(rs.getInt(1));  
	            e.setFirstname(rs.getString(3));  
	            e.setLastname(rs.getString(2)); 
	            return e;  
	        }  
	    });  
	} 
	
	public List<Materia> getClassesAssigned(int id){  
		String sql="SELECT cl.* FROM class cl, class_student cs WHERE cl.code = cs.classCode AND cs.studentId="+id+""; 
		
	    return template.query(sql,new RowMapper<Materia>(){  
	    	
	        public Materia mapRow(ResultSet rs, int row) throws SQLException {  
	        	Materia e=new Materia();  
	            e.setCode(rs.getString(1));  
	            e.setTitle(rs.getString(2));  
	            e.setDescription(rs.getString(3)); 
	            return e;  
	        }  
	    });  
	} 

}
