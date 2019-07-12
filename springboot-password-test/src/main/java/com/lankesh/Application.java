package com.lankesh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 */

/**
 * Main application file
 * @author Lankesh Kumar
 *
 */
@SpringBootApplication
@ComponentScan("com.lankesh")
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
