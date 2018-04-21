package cn.itcast.ssm.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class CustomerController {
	// @CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView getIndex(HttpServletResponse response) {
		// res.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, exception");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		ModelAndView mv = new ModelAndView("fq");
		mv.addObject("username", "qqqqqqqqqqq");
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
}
