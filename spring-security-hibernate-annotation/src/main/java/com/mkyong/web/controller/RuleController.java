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


@Controller
public class RuleController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	public RuleController() {
		System.out.println("RuleController()");
	}

	@RequestMapping(value = "main/newRule", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		/*Lista de proyectos ¿que informacion muestro del proyecto?
		Personal personal = new Personal();
		model.addObject("personal", personal);*/
		model.setViewName("ruleForm");
		return model;
	}
}
