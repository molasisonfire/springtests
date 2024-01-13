package sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "applicationName")
    public String applicationName(){
        return "sales system";
    }

    @Bean(name = "outraConfig")
    public String outraConfig(){
        return "outraConfig";
    }
}
