package cn.njcit.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author win7 这是一个工具类,为了测试springboot 中的spring容器注入的bean
 */
@Configuration
public class BeanTools implements ApplicationContextAware {
	public static ApplicationContext applicationContext;
	@Value("${spring.datasource.url}")
	String dbUrl;

	@Value("${spring.datasource.username}")
	String username;

	@Value("${spring.datasource.password}")
	String password;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}

	public static Object getBean(Class classname) {
		try {
			Object _restTemplate = applicationContext.getBean(classname);
			return _restTemplate;
		} catch (Exception e) {
			return "";
		}
	}

	public static void setApplicationContext1(ApplicationContext context) {
		applicationContext = context;
	}
}
