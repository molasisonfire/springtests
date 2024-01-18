package sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sales.model.Customer;
import sales.repository.CustomerRepo;

@SpringBootApplication
@ComponentScan(basePackages =  {"sales.repository","sales.service", "sales"})
@RestController
public class SalesApplication {

    @Value("${application.name}")
    private String value;

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @Dog
    private Animal animal;

    @Bean(name="animal")
    public CommandLineRunner execute(){
        return args -> {
            this.animal.doNoise();
        };
    }

    @Bean(name="sales")
    public CommandLineRunner init(@Autowired CustomerRepo customers){
        return args -> {
            customers.save(new Customer( "John"));
            customers.save(new Customer( "Anselmo"));
            customers.findAll().forEach(System.out::println);
            customers.delete(new Customer(2,"Kite"));
            customers.save(new Customer(2,"Kite"));
            customers.findAll().forEach(System.out::println);
            customers.findCustomersByName("Kite").forEach(System.out::println);

        };
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return value;
    }


    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class,args);
    }
}
