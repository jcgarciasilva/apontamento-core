package br.com.oportuna.apontamentocore.service;

import com.querydsl.core.annotations.QueryEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document("services")
@QueryEntity
public class Service {

  @Id
  String id;

  @NonNull
  String code;

  @NonNull
  String name;

}