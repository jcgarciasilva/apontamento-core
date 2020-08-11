package br.com.oportuna.apontamentocore.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

import br.com.oportuna.apontamentocore.configurations.BeanValidadorTests;

public class UserTests extends BeanValidadorTests {

  @Test
  public void shouldNotCreateUser() {
    User user = new User();
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldNotCreateWithNullUserName() {
    User user = new User(null, null, null, "My user name", "myemail@email.com", null);
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldNotCreateWithBlankUserName() {
    User user = new User(null, null, " ", "My user name", "myemail@email.com", null);
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldNotCreateWithBlankName() {
    User user = new User(null, null, "user", " ", "myemail@email.com", null);
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldNotCreateWithNullName() {
    User user = new User(null, null, "user", null, "myemail@email.com", null);
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldNotCreateWithNullEmail() {
    User user = new User(null, null, "user", "My user name", null, null);
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldNotCreateWithInvalidEmail() {
    User user = new User(null, null, "user", "My user name", "teste", null);
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }

  @Test
  public void shouldNotCreateWithBlankEmail() {
    User user = new User(null, null, "user", "My user name", " ", null);
    Set<ConstraintViolation<User>> violations = validator.validate(user);

    assertThat(violations).isNotEmpty();

  }
}