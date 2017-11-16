package com.test.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String form(@RequestParam(value="iddd",defaultValue="") String id, String pwd,
			HttpSession session) {
		logger.info("아이디:" + id);
		logger.info("패스워드 : " + pwd);
		logger.info("sessionID : " + session);

		return "redirect:/form";
	}

}




