package sales;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class SecondConfig {
    @Bean
    public CommandLineRunner execute(){
        return ars -> {
            System.out.println("RUN DEV CONFIG");
        };
    }
}
