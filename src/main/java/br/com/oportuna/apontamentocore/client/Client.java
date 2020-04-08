package br.com.oportuna.apontamentocore.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity(name = "CLIENTE")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cliCodigo")
  Integer id;
  @Column(name = "cliNome")
  @Length(min = 10, message = "Name must have minimum of 10")
  String name;

}