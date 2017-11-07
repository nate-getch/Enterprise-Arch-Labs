package exercise11_1_spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		Greeting greetingService = context.getBean("greetingService", Greeting.class);
		greetingService.sayHello();
	}
}
