package com.devfelipe.transparencyportal.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.YearMonth;

/**
 * JPA AttributeConverter for converting YearMonth objects to and from database columns.
 *
 * @see YearMonth
 */
@Converter(autoApply = true)
public class YearMonthConverter implements AttributeConverter<YearMonth, String> {
    @Override
    public String convertToDatabaseColumn(YearMonth yearMonth) {
        return yearMonth.toString();
    }

    @Override
    public YearMonth convertToEntityAttribute(String dbData) {
        return YearMonth.parse(dbData);
    }
}
