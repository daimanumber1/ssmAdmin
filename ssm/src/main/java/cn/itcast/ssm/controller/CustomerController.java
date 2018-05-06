package cn.itcast.ssm.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;
import cn.itcast.ssm.service.CustomerService;
import cn.itcast.ssm.service.SystemService;
import cn.itcast.ssm.service.UserService;
import cn.itcast.ssm.service.impl.SystemServiceImpl;

//@CrossOrigin(origins = "http://127.0.0.1:5500",allowCredentials="true", maxAge = 3600,allowedHeaders="'Access-Control-Allow-Headers:accept,content-type, exception",methods=RequestMethod.GET)
@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/home", method = RequestMethod.GET)
	public ModelAndView getHome(@RequestParam(value = "currPage") int currPage, HttpServletResponse response,
			@RequestParam(value = "a", required = false) String a,
			@RequestParam(value = "b", required = false) String b,
			@RequestParam(value = "c", required = false) String c,
			@RequestParam(value = "d", required = false) String d) {
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,content-type, exception");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		ModelAndView mv = new ModelAndView();
		// 搜索框中的客户级别
		List<BaseDict> clientLevelList = systemService.findBaseDictListByType("006");
		// 搜索框中的所属行业
		List<BaseDict> industryList = systemService.findBaseDictListByType("001");
		// 搜索框中的客户来源
		List<BaseDict> clientSourceList = systemService.findBaseDictListByType("002");
		mv.addObject("clientSourceList", clientSourceList);
		mv.addObject("industryList", industryList);
		mv.addObject("clientLevelList", clientLevelList);
		// --------------------分割线---------------
		// 分页插件pageHelper
		PageHelper.startPage(currPage, 10);
		List<Customer> list = customerService.findCustomerList();
		PageInfo page = new PageInfo(list);
		mv.addObject("page", list);
		mv.addObject("aa", page);
		mv.setView(new MappingJackson2JsonView());
		return mv;

	}

	@RequestMapping("/api/hh")
	public ModelAndView d(@RequestParam(value = "currPage") int currPage, HttpServletResponse response,
			@RequestParam(value = "a", required = false) String a, String b, String c, String d) {
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,content-type, exception");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		System.out.println("a---" + a);
		System.out.println("b---" + b);
		System.out.println("c---" + c);
		System.out.println("d---" + d);
		ModelAndView mv = new ModelAndView();
		// 搜索框中的客户级别
		List<BaseDict> clientLevelList = systemService.findBaseDictListByType("006");
		// 搜索框中的所属行业
		List<BaseDict> industryList = systemService.findBaseDictListByType("001");
		// 搜索框中的客户来源
		List<BaseDict> clientSourceList = systemService.findBaseDictListByType("002");
		mv.addObject("clientSourceList", clientSourceList);
		mv.addObject("industryList", industryList);
		mv.addObject("clientLevelList", clientLevelList);
		// --------------------分割线---------------
		// 分页插件pageHelper
		PageHelper.startPage(currPage, 10);
		List<Customer> list = customerService.test(a, b, c, d);
		PageInfo page = new PageInfo(list);
		mv.addObject("page", list);
		mv.addObject("aa", page);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	@RequestMapping("/api/delete")
	public ModelAndView deleteClient(HttpServletResponse response, @RequestParam("id") String id) {
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,content-type, exception");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		ModelAndView mv = new ModelAndView();
		boolean b = customerService.deleteClient(id);
		mv.addObject("isDelete", b);
		mv.setView(new MappingJackson2JsonView());
		return mv;

	}

	@RequestMapping("/api/update")
	public ModelAndView updateClient(HttpServletResponse response, String id, @RequestParam("name") String name,
			String source, String industry, String level, String linkman, String phone, String mobile, String zipcode,
			String address) {
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,content-type, exception");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		ModelAndView mv = new ModelAndView();
		int b = customerService.updateClient(id, name, source, industry, level, linkman, phone, mobile, zipcode,
				address);
		mv.addObject("isUpdate", b);
		System.out.println(b + "return");
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}

	@RequestMapping("/api/doLogin")
	public ModelAndView updateClient(HttpServletResponse response, String username, String password) {
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,content-type, exception");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		ModelAndView mv = new ModelAndView();
		int b = userService.doLogin(username, password);
		if(b == 1) {
			Cookie c = new Cookie(username, password);
			c.setMaxAge(60);
			c.setPath("/");
			response.addCookie(c);
			System.out.println(c.getValue());
		}
		mv.addObject("doLogin", b);
		System.out.println(b + "return");
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
}
