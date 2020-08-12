package br.com.oportuna.apontamentocore.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

import br.com.oportuna.apontamentocore.configurations.BeanValidadorTests;

public class CustomerTests extends BeanValidadorTests {

  @Test
  public void shouldNotCreateCustomerWith3CharsOnName() {
    Customer customer = new Customer(null, null, "fs", null);
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldCreateCustomerWithMoreThanThreeCharsOnName() {
    Customer customer = new Customer(null, null, "Oportuna", null);
    Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

    assertThat(violations).isEmpty();

  }

}