package br.com.oportuna.apontamentocore.timetrack;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.oportuna.apontamentocore.client.Client;
import br.com.oportuna.apontamentocore.data.AuditableEntity;
import br.com.oportuna.apontamentocore.projects.Project;
import br.com.oportuna.apontamentocore.service.Service;
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

  Client client;
  Service service;
  @DBRef
  Project project;

  LocalDate date;
  BigDecimal spentTime;
  String description;
}