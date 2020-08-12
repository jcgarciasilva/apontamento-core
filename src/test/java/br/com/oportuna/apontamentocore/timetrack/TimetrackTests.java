package br.com.oportuna.apontamentocore.timetrack;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

import br.com.oportuna.apontamentocore.configurations.BeanValidadorTests;
import br.com.oportuna.apontamentocore.customer.Customer;
import br.com.oportuna.apontamentocore.projects.Project;
import br.com.oportuna.apontamentocore.service.Service;
import br.com.oportuna.apontamentocore.user.User;

public class TimetrackTests extends BeanValidadorTests {

  Customer customer = new Customer(null, null, "Oportuna", null);
  Project project = new Project(null, "2020123", "New Project", " New description ", null);
  Service sercice = new Service("D", "Dev");

  @Test
  void shouldNotCreateTimetrack() {
    Timetrack timetrack = new Timetrack(new Customer(), new Service(), new Project(), new User(), LocalDate.now(),
        BigDecimal.ZERO, "asdojasdjaoisdjasodi");
    Set<ConstraintViolation<Timetrack>> violations = validator.validate(timetrack);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldNotCreateTimetrackWithSpentTimeLowerThenHalf() {
    Timetrack timetrack = new Timetrack(customer, sercice, project, new User(), LocalDate.now(), BigDecimal.ZERO,
        "asdojasdjaoisdjasodi");
    Set<ConstraintViolation<Timetrack>> violations = validator.validate(timetrack);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldCreateTimetrackWithSpentTimeHigherThenHalf() {
    Timetrack timetrack = new Timetrack(customer, sercice, project, new User(), LocalDate.now(), BigDecimal.ONE,
        "asdojasdjaoisdjasodi");
    Set<ConstraintViolation<Timetrack>> violations = validator.validate(timetrack);

    assertThat(violations).isEmpty();

  }

  @Test
  void shouldCreateTimetrackWithSpentTimeEqualsHalf() {
    Timetrack timetrack = new Timetrack(customer, sercice, project, new User(), LocalDate.now(), new BigDecimal("0.50"),
        "asdojasdjaoisdjasodi");
    Set<ConstraintViolation<Timetrack>> violations = validator.validate(timetrack);

    assertThat(violations).isEmpty();

  }

}