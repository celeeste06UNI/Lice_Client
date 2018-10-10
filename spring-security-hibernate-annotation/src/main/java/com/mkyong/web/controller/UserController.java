package com.mkyong.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	/*@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		//List<Employee> listEmployee = employeeService.getAllEmployees();
		//model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;
	}*/
	
/*	@RequestMapping(value = "/inicio")
	public ModelAndView inicio(ModelAndView model) throws IOException {
		//List<Employee> listEmployee = employeeService.getAllEmployees();
		//model.addObject("listEmployee", listEmployee);
		model.setViewName("inicio");
		return model;
	}*/

	@RequestMapping(value = "main/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Personal personal = new Personal();
		model.addObject("personal", personal);
		model.setViewName("personalForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("personal") Personal personal) {
		personalService.addPersonal(personal);
		/*if (user.getUsername() != "") { // if employee id is 0 then creating the
			// employee other updating the employee
			userService.addPersonal(personal);
		} else {
			userService.updateUser(personal);
		}*/
		return new ModelAndView("redirect:/");
	}

/*	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		userService.deleteUser(userId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUser(userId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", user);

		return model;
	}*/
	
	@RequestMapping(value = "main/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployee(ModelAndView model) {
		List<Personal> listPersonal = personalService.getAllPersonal();
		model.addObject("listPersonal", listPersonal);
		model.setViewName("personalList");
		return model;
	}

}

