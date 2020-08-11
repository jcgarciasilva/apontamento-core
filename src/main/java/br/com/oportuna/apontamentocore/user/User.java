package br.com.oportuna.apontamentocore.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
@Document("users")
@QueryEntity
@EqualsAndHashCode(callSuper = true)
public class User extends AuditableEntity {

  @Id
  String id;

  String socialId;

  @NotBlank
  String username;

  @NotBlank
  String name;

  @Email
  @NotBlank
  String email;

  // legacy
  String password;

}