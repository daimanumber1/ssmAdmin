package cn.itcast.ssm.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;
import cn.itcast.ssm.service.CustomerService;
import cn.itcast.ssm.service.SystemService;
import cn.itcast.ssm.service.impl.SystemServiceImpl;

//@CrossOrigin(origins = "http://127.0.0.1:5500",allowCredentials="true", maxAge = 3600,allowedHeaders="'Access-Control-Allow-Headers:accept,content-type, exception",methods=RequestMethod.GET)
@Controller
public class CustomerController {
	 @Autowired
	 private CustomerService customerService ;
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getHome(HttpServletResponse response) {
		 response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,content-type, exception");
		 response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		 response.setHeader("Access-Control-Allow-Credentials", "true");
		 response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		ModelAndView mv = new ModelAndView();
//		搜索框中的客户级别
		List<BaseDict> clientLevelList= systemService.findBaseDictListByType("006");
//		搜索框中的所属行业
		List<BaseDict> industryList = systemService.findBaseDictListByType("001");
//		搜索框中的客户来源
		List<BaseDict> clientSourceList = systemService.findBaseDictListByType("002");
		mv.addObject("clientSourceList", clientSourceList);
		mv.addObject("industryList", industryList);
		mv.addObject("clientLevelList", clientLevelList);
//		--------------------分割线---------------
//		分页插件pageHelper
		PageHelper.startPage(1, 2);
		List<Customer> list = customerService.findCustomerList();
		PageInfo page = new PageInfo(list);
		//测试PageInfo全部属性
		//PageInfo包含了非常全面的分页属性
//		assertEquals(1, page.getPageNum());
//		assertEquals(, page.getPageSize());
		System.out.println(list);
		System.out.println(page);
		mv.addObject("page", list);
		mv.setView(new MappingJackson2JsonView());
		return mv;

	}

	// // @CrossOrigin(origins = "*", maxAge = 3600)
	// @RequestMapping(value = "/hello", method = RequestMethod.GET)
	// public ModelAndView get(HttpServletResponse response) {
	// // res.setHeader("Access-Control-Allow-Origin", "*");
	// response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,
	// content-type, exception");
	// response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT,
	// DELETE, TRACE, OPTIONS, PATCH");
	// response.setHeader("Access-Control-Allow-Credentials", "true");
	// response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
	// ModelAndView mv = new ModelAndView("fq");
	// mv.addObject("username", "qqqqqqqqqqq");
	// mv.setView(new MappingJackson2JsonView());
	// return mv;
	// }
}
