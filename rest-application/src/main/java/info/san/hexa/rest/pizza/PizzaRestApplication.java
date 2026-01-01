package info.san.hexa.rest.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"info.san.hexa"})
@EntityScan("info.san.hexa.infrastructure.persistence.jpa.entities")
@EnableJpaRepositories("info.san.hexa.infrastructure.persistence.jpa.dao")
public class PizzaRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaRestApplication.class, args);
    }

}
