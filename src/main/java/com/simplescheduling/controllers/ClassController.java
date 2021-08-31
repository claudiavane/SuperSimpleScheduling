package com.simplescheduling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplescheduling.beans.Materia;
import com.simplescheduling.beans.Student;
import com.simplescheduling.dao.ClassDao;

@Controller
public class ClassController {
	@Autowired
	ClassDao dao;
	
	/* It provides list of classes in model object */  
    @RequestMapping("/viewClassList")  
    public String listClass(Model m){  
        List<Materia> list=dao.getClassList();  
        m.addAttribute("list",list);
        return "viewClassList";  
    }
    /*It displays a form to input data*/
    @RequestMapping("/classForm")  
    public String showform(Model m){  
    	m.addAttribute("command", new Materia());
    	return "classForm"; 
    }
    /*It saves object into database*/  
    @RequestMapping(value="/saveClass",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cl") Materia cl){  
        dao.save(cl);  
        return "redirect:/viewClassList"; 
    }
    
    /* It displays object data into form for the given id.*/  
    @RequestMapping(value="/editClass/{code}")  
    public String edit(@PathVariable String code, Model m){ 
    	
        Materia mat=dao.getMateriaByCode(code);  
        m.addAttribute("command", mat);
        
        return "editClassForm";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsaveClass",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("mat") Materia mat){  
        dao.update(mat);  
        
        return "redirect:/viewClassList";  
    }
    
    /* It deletes record for the given id in URL and redirects to /viewClassList */  
    @RequestMapping(value="/deleteClass/{code}",method = RequestMethod.GET)  
    public String delete(@PathVariable String code){  
        dao.delete(code);  
        
        return "redirect:/viewClassList";  
    }
    
    /* It displays object data into form for the given id*/  
    @RequestMapping(value="/viewAssignStudent/{code}")  
    public String viewStudents(@PathVariable String code, Model m){ 
    	
        List<Student> list=dao.getStudentsAssigned(code);  
        m.addAttribute("list",list);
        m.addAttribute("classCode",code);
        
        return "assignedStudentList"; 
        
    }

}
