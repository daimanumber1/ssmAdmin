package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.service.CustomerService;
import cn.itcast.ssm.service.SystemService;
import cn.itcast.ssm.service.impl.SystemServiceImpl;

//@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
@Controller
public class CustomerController {
//	@Autowired
//	private CustomerService cusService ;
	@Autowired
	private SystemService systemService;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, exception");
		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		ModelAndView mv = new ModelAndView(); 
		List<BaseDict> findBaseDictListByType = systemService.findBaseDictListByType("006");
		System.out.println(findBaseDictListByType);
		mv.addObject("username", "qqqqqqqqqqq");
		mv.addObject("aa", findBaseDictListByType);
		mv.setView(new MappingJackson2JsonView());
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
//	// @CrossOrigin(origins = "*", maxAge = 3600)
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//	public ModelAndView get(HttpServletResponse response) {
//		// res.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, exception");
//		response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
//		ModelAndView mv = new ModelAndView("fq");
//		mv.addObject("username", "qqqqqqqqqqq");
//		mv.setView(new MappingJackson2JsonView());
//		return mv;
//	}
}
