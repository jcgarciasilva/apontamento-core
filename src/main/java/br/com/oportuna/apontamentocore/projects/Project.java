package br.com.oportuna.apontamentocore.projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.oportuna.apontamentocore.data.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Projeto")
public class Project extends AuditableEntity{

  @Id
  @Column(name = "prjCodigo", length = 255, nullable = false)
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @Column(name = "prjNome", length = 255, nullable = false)
  @NotNull
  @NotBlank(message = "project.description.cannot.be.null")
  private String name;

  @Column(name = "prjDescricao", length = 255, nullable = false)
  @NotNull
  @NotBlank(message = "project.description.cannot.be.null")
  private String description;

}