package br.com.oportuna.apontamentocore.data;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * ActiveStatusConverter
 */
@Converter(autoApply = true)
public class ActiveStatusConverter implements AttributeConverter<ActiveStatus, String> {

  @Override
  public String convertToDatabaseColumn(ActiveStatus obj) {
    return obj.getCode();
  }

  @Override
  public ActiveStatus convertToEntityAttribute(String dbData) {
    return ActiveStatus.fromCode(dbData);
  }

}
