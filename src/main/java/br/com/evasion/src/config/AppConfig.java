package br.com.evasion.src.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Log4j2
@Configuration
@EnableJpaRepositories("br.com.evasion.src.repository")
@EntityScan("br.com.evasion.src.entity")
@ComponentScan("br.com.evasion.src")
@RequiredArgsConstructor
@EnableAutoConfiguration
public class AppConfig {

    private final Environment env;

    @PostConstruct
    public void init() {

        log.info("***** CONFIGURATION *****");
        log.info("activeProfiles -> {}!", Arrays.toString(env.getActiveProfiles()));
    }
}
