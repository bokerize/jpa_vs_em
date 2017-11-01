package com.bok.demo;

import com.bok.demo.service.SamService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/test")
@SpringBootApplication
public class DemoApplication {


	@Inject
	SamService samService;

	@GetMapping("/em/{reqId}")
	public void testSamEm(@PathVariable("reqId") String reqId) {
		samService.doEmService(reqId, false);
	}

	@GetMapping("/jpa/{reqId}")
	public void testSamJpa(@PathVariable("reqId") String reqId) {
		samService.doJpaService(reqId, false);
	}

	@GetMapping("/jpaf/{reqId}")
	public void testSamJpaf(@PathVariable("reqId") String reqId) {
		samService.doJpaService(reqId, true);
	}

	@GetMapping("/jpapf/{reqId}")
	public void testSamJpaPf(@PathVariable("reqId") String reqId) {
		samService.doJpaServicePreMark(reqId, true);
	}
	public static void main(String[] args) {

		System.out.println("running class 0 ");

		SpringApplication.run(DemoApplication.class, args);

		System.out.println("running class 1 ");

	}
}
