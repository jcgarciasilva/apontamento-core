package br.com.oportuna.apontamentocore.service;

import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("services")
@QueryEntity
public class Service {

  @Id
  String id;

  String code;

  String name;

}