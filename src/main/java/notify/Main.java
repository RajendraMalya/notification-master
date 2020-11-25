package notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;

@EnableAutoConfiguration
@SpringBootApplication
@EnableEmailTools
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
