package br.com.oportuna.apontamentocore.projects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class Project extends AuditableEntity {

  @Id
  @Column(name = "prjId")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "prjCodigo", length = 100)
  @NotNull
  @NotBlank(message = "project.code.cannot.be.null")
  private String code;

  @Column(name = "prjNome", length = 100)
  @NotNull
  @NotBlank(message = "project.name.cannot.be.null")
  private String name;

  @Column(name = "prjDescricao", length = 4000)
  @NotNull
  @NotBlank(message = "project.description.cannot.be.null")
  private String description;

}