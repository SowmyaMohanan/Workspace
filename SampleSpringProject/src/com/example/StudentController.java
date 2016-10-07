package com.example;

import java.util.List;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.StudentDao;
import com.google.gson.Gson;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDao dao;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("student", "command", new Student());
	   }
	   
	   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
/*	   public String addStudent(@ModelAttribute("SampleSpringProject")Student student, 		   
 		public ModelAndView addStudent(@ModelAttribute("SampleSpringProject")Student student, 
		 ModelAndView modelview) { */
	   public @ResponseBody String addStudent(HttpServletRequest request, HttpServletResponse response) {
		   Student studentNew = new Student(Integer.parseInt(request.getParameter("id")),
				   Integer.parseInt(request.getParameter("age")),
				   request.getParameter("name"));
		   
		      dao.saveUserDetail(studentNew);
		      
		      List<Student> stud = dao.fetchAll();
		      String jsonStud = new Gson().toJson(stud);
		      
		      response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
			   //modelview.addObject("studObj", stud);
			  // modelview.setViewName("student");
			   
		   /*model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());*/
	      
	      /*return "result";*/
	     // return modelview;
		      
		      return jsonStud;
	   }
}
