package com.simplescheduling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplescheduling.beans.Student;
import com.simplescheduling.beans.Materia;
import com.simplescheduling.dao.StudentDao;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;
	
	/* It provides list of employees in model object */  
    @RequestMapping("/")  
    public String listStudent(Model m){  
        List<Student> list=dao.getStudents();  
        m.addAttribute("list",list);
        return "index";  
    }
    
    /*It displays a form to input data*/
    @RequestMapping("/studentForm")  
    public String showform(Model m){  
    	m.addAttribute("command", new Student());
    	return "studentForm"; 
    }
    /*It saves object into database.*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("student") Student student){  
        dao.save(student);  
        return "redirect:/"; 
    }
    
    /* It displays object data into form for the given id.*/  
    @RequestMapping(value="/editStudent/{id}")  
    public String edit(@PathVariable int id, Model m){ 
    	
        Student student=dao.getStudentById(id);  
        m.addAttribute("command", student);
        return "editStudentForm";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("student") Student student){  
        dao.update(student);  
        return "redirect:/";  
    }
    /* It deletes record for the given id in URL*/  
    @RequestMapping(value="/deleteStudent/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/";  
    }
    
    /* It displays object data into form for the given id.*/  
    @RequestMapping(value="/viewAssignClass/{id}")  
    public String viewClasses(@PathVariable int id, Model m){ 
    	
        List<Materia> list=dao.getClassesAssigned(id);  
        Student student = dao.getStudentById(id);
        
        m.addAttribute("listClassAssigned",list);
        m.addAttribute("student",student);
        
        return "assignedClassList"; 
        
    }
    
    
    

}
