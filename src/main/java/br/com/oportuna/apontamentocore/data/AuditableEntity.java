package br.com.oportuna.apontamentocore.data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AuditableEntity {

  @CreatedBy
  @Column(name = "createUser", updatable = false)
  String createUser;

  @CreatedDate
  @Column(name = "createDate", updatable = false, columnDefinition = "Date")
  LocalDateTime createDate;

  @LastModifiedBy
  @Column(name = "updateUser", insertable = false)
  String updateUser;

  @LastModifiedDate
  @Column(name = "updateDate", insertable = false, columnDefinition = "Date")
  LocalDateTime updateDate;

  @Column(name = "activeStatus")
  ActiveStatus status = ActiveStatus.ACTIVE;


  /**
   * @return the id
   */
  public abstract Serializable getId();

}
