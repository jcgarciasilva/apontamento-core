package br.com.oportuna.apontamentocore.timetrack;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.oportuna.apontamentocore.client.Client;
import br.com.oportuna.apontamentocore.data.AuditableEntity;
import br.com.oportuna.apontamentocore.projects.Project;
import br.com.oportuna.apontamentocore.service.Service;
import br.com.oportuna.apontamentocore.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("timetracks")
@QueryEntity
@EqualsAndHashCode(callSuper = true)
public class Timetrack extends AuditableEntity {

  @Id
  String id;

  @DBRef
  @NotNull
  Client client;

  @NotNull
  Service service;

  @DBRef
  @NotNull
  Project project;

  @DBRef
  @NotNull
  User creator;

  @NotNull
  LocalDate date;

  @NotNull
  @DecimalMin(value = "0.5", inclusive = true)
  BigDecimal spentTime;

  @NotBlank
  @Size(min = 10)
  String description;
}