package br.com.oportuna.apontamentocore.customer;

import javax.validation.constraints.Size;

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
@Document("customers")
@QueryEntity
public class Customer extends AuditableEntity {

  @Id
  String id;

  Integer sqlId;

  @Size(min = 3, message = "Name must have minimum of 3")
  String name;

  String cnpj;

}
