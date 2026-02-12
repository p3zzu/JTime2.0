package it.unicam.cs.mpgc.jtime118724.Util;

import java.time.Duration;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DaStringaUmanaAStringaIso8610 {

    private static final Pattern PART =
            Pattern.compile("(\\d+)\\s*(giorno|giorni|ora|ore|minuto|minuti|secondo|secondi)");

    public static String converti(String human) {
        if (human == null || human.isBlank()) {
            throw new IllegalArgumentException("Stima vuota.");
        }

        String s = human.toLowerCase(Locale.ROOT);

        long days = 0, hours = 0, minutes = 0, seconds = 0;
        boolean found = false;

        Matcher m = PART.matcher(s);
        while (m.find()) {
            found = true;
            long value = Long.parseLong(m.group(1));
            String unit = m.group(2);

            switch (unit) {
                case "giorno", "giorni"   -> days += value;
                case "ora", "ore"         -> hours += value;
                case "minuto", "minuti"   -> minutes += value;
                case "secondo", "secondi" -> seconds += value;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Formato non riconosciuto: " + human);
        }

        long totalSeconds = seconds
                + minutes * 60
                + hours * 3600
                + days * 86400;

        return Duration.ofSeconds(totalSeconds).toString(); // ISO-8601 (es. PT2H30M)
    }

}
