package br.com.oportuna.apontamentocore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * SecurityAuditor
 */
@Configuration
@EnableMongoAuditing
public class SecurityAuditor {

  @Bean
  public AuditorAware<String> myAuditorProvider() {
    return new AuditorAware<String>() {
      @Override
      public java.util.Optional<String> getCurrentAuditor() {
        return java.util.Optional.of("ADMIN");
      }
    };
  }

}