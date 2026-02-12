package it.unicam.cs.mpgc.jtime118724.Util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

@Converter(autoApply = true)
public class ConvertitoreDurationStringISO8610 implements AttributeConverter<Duration, String> {
    @Override
    public String convertToDatabaseColumn(Duration duration) {
        return duration == null ? null : duration.toString();
    }

    @Override
    public Duration convertToEntityAttribute(String s) {
        return s == null ? null : Duration.parse(s);
    }
}
