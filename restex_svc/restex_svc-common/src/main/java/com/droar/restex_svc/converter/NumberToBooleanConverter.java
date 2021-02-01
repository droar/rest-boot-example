package com.droar.restex_svc.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class NumberToBooleanConverter implements AttributeConverter<Boolean, Integer> {

  private static final Integer TRUE = 1;
  private static final Integer FALSE = 0;

  @Override
  public Integer convertToDatabaseColumn(final Boolean attribute) {
    Integer numero;

    if (attribute == null) {
      numero = null;
    } else if (attribute) {
      numero = NumberToBooleanConverter.TRUE;
    } else {
      numero = NumberToBooleanConverter.FALSE;
    }

    return numero;
  }

  @Override
  public Boolean convertToEntityAttribute(Integer dbData) {
    Boolean boolVal = null;

    if (dbData == null) {
      boolVal = null;
    } else if (dbData.equals(NumberToBooleanConverter.TRUE)) {
      boolVal = Boolean.TRUE;
    } else if (dbData.equals(NumberToBooleanConverter.FALSE)) {
      boolVal = Boolean.FALSE;
    }
    return boolVal;
  }
}
