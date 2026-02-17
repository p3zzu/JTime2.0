package it.unicam.cs.mpgc.jtime118724.Util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

/**
 * Convertitore di tipo di dato , lato persistenza.
 */
@Converter(autoApply = true)
public class ConvertitoreLatoPersistenza implements AttributeConverter<Duration, String> {

    /**
     * Dato un oggetto di tipo Duration mi restituisce una string con contenuto scritto in formato iso-8610
     * @param duration
     * @return String iso-8610
     */
    @Override
    public String convertToDatabaseColumn(Duration duration) {

        return duration == null ? null : duration.toString();
    }

    /**
     * Data una stringa s scritto in formato iso-8610 mi restituisce un oggetto di tipo Duration
     * con i campip inizializzati con le informazioni passate dalla stringa.
     * @param s
     * @return oggetto Duration
     */
    @Override
    public Duration convertToEntityAttribute(String s) {
        return s == null ? null : Duration.parse(s);
    }
}
