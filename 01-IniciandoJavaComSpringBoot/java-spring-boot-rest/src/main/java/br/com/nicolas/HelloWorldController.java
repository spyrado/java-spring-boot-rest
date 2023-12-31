package br.com.nicolas;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello-world")
	public HelloWorld helloWorld(@RequestParam(value = "teste", defaultValue = "World") String name) {
		System.out.println(name);
		return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
	}
}
