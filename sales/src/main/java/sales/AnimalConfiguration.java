package sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfiguration {
    @Bean(name="Dog")
    public Animal dog(){
        return new Animal() {
            @Override
            public void doNoise() {
                System.out.println("arf");
            }
        };
    }

    @Bean(name="Cat")
    public Animal cat(){
        return new Animal() {
            @Override
            public void doNoise() {
                System.out.println("meow");
            }
        };
    }
}
