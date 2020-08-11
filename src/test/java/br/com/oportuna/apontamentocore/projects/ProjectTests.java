package br.com.oportuna.apontamentocore.projects;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

import br.com.oportuna.apontamentocore.configurations.BeanValidadorTests;

public class ProjectTests extends BeanValidadorTests {

  @Test
  void shouldNotCreateProjectWithNullFields() {
    Project project = new Project();
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldNotCreateProjectWithNullCode() {
    Project project = new Project(null, null, "New Project", "New Project description", null);
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldNotCreateProjectWithBlankCode() {
    Project project = new Project(null, " ", "New Project", "New Project description", null);
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldNotCreateProjectWithNullName() {
    Project project = new Project(null, "2020123", null, "New Project description", null);
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldNotCreateProjectWithBlankName() {
    Project project = new Project(null, "2020123", "  ", "New Project description", null);
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldNotCreateProjectWithNullDescription() {
    Project project = new Project(null, "2020123", "New Project", null, null);
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldNotCreateProjectWithBlankDescription() {
    Project project = new Project(null, "2020123", "New Project", "  ", null);
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isNotEmpty();

  }

  @Test
  void shouldCreateProject() {
    Project project = new Project(null, "2020123", "New Project", " New description ", null);
    Set<ConstraintViolation<Project>> violations = validator.validate(project);

    assertThat(violations).isEmpty();

  }

}