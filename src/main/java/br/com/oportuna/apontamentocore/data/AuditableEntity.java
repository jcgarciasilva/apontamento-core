package br.com.oportuna.apontamentocore.data;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
public abstract class AuditableEntity {

  @CreatedBy
  String createUser;

  @CreatedDate
  LocalDateTime createDate;

  @LastModifiedBy
  String updateUser;

  @LastModifiedDate
  LocalDateTime updateDate;

  ActiveStatus status = ActiveStatus.ACTIVE;


  /**
   * @return the id
   */
  public abstract Serializable getId();

}
