package sales;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Development
public class SecondConfig {
    @Bean(name="SecondConfig")
    public CommandLineRunner execute(){
        return ars -> {
            System.out.println("RUN DEV CONFIG");
        };
    }
}
