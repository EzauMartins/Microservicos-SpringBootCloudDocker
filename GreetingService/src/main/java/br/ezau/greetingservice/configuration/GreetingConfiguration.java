package br.ezau.greetingservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("greeting-service")
public class GreetingConfiguration {

    private String greeting;
    private String defaultvalue;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultValue() {
        return defaultvalue;
    }

    public void setDefaultValue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }
}
