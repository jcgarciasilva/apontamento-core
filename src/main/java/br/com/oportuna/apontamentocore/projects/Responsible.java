package br.com.oportuna.apontamentocore.projects;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Responsible
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
class Responsible {

  String name;
  String email;

}