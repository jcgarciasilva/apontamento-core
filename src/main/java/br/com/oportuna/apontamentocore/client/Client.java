package br.com.oportuna.apontamentocore.client;

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
@Document("Clients")
@QueryEntity
public class Client extends AuditableEntity {

  @Id
  String id;
  // @Le (min = 3, message = "Name must have minimum of 3")
  String name;

}
