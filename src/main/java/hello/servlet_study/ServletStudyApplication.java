package hello.servlet_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletStudyApplication.class, args);
	}

}
