package br.com.oportuna.apontamentocore.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

import br.com.oportuna.apontamentocore.configurations.BeanValidadorTests;

public class ServiceTests extends BeanValidadorTests {

  @Test
  public void shouldNotCreateService() {
    Service service = new Service();
    Set<ConstraintViolation<Service>> violations = validator.validate(service);

    assertThat(violations).isEmpty();

  }

}