package cn.njcit.controller;

import cn.njcit.utils.BeanTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by FlySheep on 17/3/25.
 */
@EnableTransactionManagement
// 需要事务的时候加上
@RestController
public class PersonController {
	@Autowired
	BeanTools beanTools;

	@RequestMapping("/transaction")
	@Transactional
	// 需要事务的时候加上
	public Boolean transaction() {

		return true;
	}

	@RequestMapping("/hello")
	public String hello() {
		ApplicationContext a = beanTools.getApplicationContext();
		String[] c = a.getBeanDefinitionNames();
		StringBuilder sb = new StringBuilder();
		for (String s : c) {
			sb.append(s);
			sb.append("\r\n");
		}
		return "hello world";
	}
}
