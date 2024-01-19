package sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import sales.model.Customer;
import sales.repository.CustomerRepo;

@SpringBootApplication
@ComponentScan(basePackages =  {"sales.repository","sales.service", "sales"})
@RestController
public class SalesApplication {

    @Bean(name="sales")
    public CommandLineRunner init(@Autowired CustomerRepo customers){
        return args -> {
            customers.save(new Customer( "John"));
            customers.save(new Customer( "Anselmo"));

        };
    }



    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class,args);
    }
}
