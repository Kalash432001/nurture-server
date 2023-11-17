package com.bal.asha.nurture.server;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class NurtureServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurtureServerApplication.class, args);
	}

}
