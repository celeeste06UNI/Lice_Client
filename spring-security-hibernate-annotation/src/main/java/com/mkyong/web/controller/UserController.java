package com.mkyong.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.users.model.Personal;
import com.mkyong.users.model.User;
import com.mkyong.users.service.PersonalService;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	public UserController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private PersonalService personalService;

	/*
	 * @RequestMapping(value = "/") public ModelAndView listEmployee(ModelAndView
	 * model) throws IOException { //List<Employee> listEmployee =
	 * employeeService.getAllEmployees(); //model.addObject("listEmployee",
	 * listEmployee); model.setViewName("home"); return model; }
	 */

	/*
	 * @RequestMapping(value = "/inicio") public ModelAndView inicio(ModelAndView
	 * model) throws IOException { //List<Employee> listEmployee =
	 * employeeService.getAllEmployees(); //model.addObject("listEmployee",
	 * listEmployee); model.setViewName("inicio"); return model; }
	 */

	@RequestMapping(value = "main/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Personal personal = new Personal();
		model.addObject("personal", personal);
		model.setViewName("personalForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("personal") Personal personal,
			@ModelAttribute("role") String role) {
		

		String password = role + ((int)(Math.random() * 50) + 1);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passwordEncriptada = passwordEncoder.encode(password);
		User user = new User(personal.getUsername(), passwordEncriptada, true);
		
		personalService.addPersonal(personal, password);
		personalService.addUserRole(user, role);
		

		return new ModelAndView("redirect:/main");
	}

	@RequestMapping(value = "/deletePersonal", method = RequestMethod.GET)
	public ModelAndView deletePersonal(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		personalService.deleteUser(username);
		personalService.deletePersonal(id);		
		return new ModelAndView("redirect:/main");
	}
	@RequestMapping(value = "/editPersonal", method = RequestMethod.GET)
	public ModelAndView editPersonal(ModelAndView model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Personal personal = personalService.getPersonal(id);
		model.addObject("personal", personal);
		model.setViewName("personalUpdate");
		return model;
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("personal") Personal personal) {
		personalService.updatePersonal(personal);
		return new ModelAndView("redirect:/main");
	}


	@RequestMapping(value = "main/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(ModelAndView model) {
		List<Personal> listPersonal = personalService.getAllPersonal();
		model.addObject("listPersonal", listPersonal);
		model.setViewName("personalList");
		return model;
	}
	/*
	 * @RequestMapping(value = "/editEmployee", method = RequestMethod.GET) public
	 * ModelAndView editContact(HttpServletRequest request) { int userId =
	 * Integer.parseInt(request.getParameter("id")); User user =
	 * userService.getUser(userId); ModelAndView model = new
	 * ModelAndView("EmployeeForm"); model.addObject("employee", user);
	 * 
	 * return model; }
	 */

}
