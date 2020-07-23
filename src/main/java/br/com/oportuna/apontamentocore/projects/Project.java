package br.com.oportuna.apontamentocore.projects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.oportuna.apontamentocore.data.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document("Projetos")
@QueryEntity
public class Project extends AuditableEntity {

  @Id
  private Long id;

  @NotNull
  @NotBlank(message = "project.code.cannot.be.null")
  private String code;

  @NotNull
  @NotBlank(message = "project.name.cannot.be.null")
  private String name;

  @NotNull
  @NotBlank(message = "project.description.cannot.be.null")
  private String description;

}