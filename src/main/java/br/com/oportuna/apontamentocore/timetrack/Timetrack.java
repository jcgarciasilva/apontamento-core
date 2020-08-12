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

import br.com.oportuna.apontamentocore.customer.Customer;
import br.com.oportuna.apontamentocore.data.AuditableEntity;
import br.com.oportuna.apontamentocore.projects.Project;
import br.com.oportuna.apontamentocore.service.Service;
import br.com.oportuna.apontamentocore.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document("timetracks")
@QueryEntity
@EqualsAndHashCode(callSuper = true)
public class Timetrack extends AuditableEntity {

  @Id
  String id;

  @DBRef
  @NotNull
  @NonNull
  Customer client;

  @NotNull
  @NonNull
  Service service;

  @DBRef
  @NotNull
  @NonNull
  Project project;

  @DBRef
  @NotNull
  @NonNull
  User creator;

  @NotNull
  @NonNull
  LocalDate date;

  @NotNull
  @DecimalMin(value = "0.5", inclusive = true)
  @NonNull
  BigDecimal spentTime;

  @NotBlank
  @Size(min = 10)
  @NonNull
  String description;
}