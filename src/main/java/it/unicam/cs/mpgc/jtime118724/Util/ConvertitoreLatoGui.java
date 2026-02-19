package it.unicam.cs.mpgc.jtime118724.Util;

import java.time.Duration;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Convertitore tipo di dato , lato GUI.
 */
// Stringa umana --> Stringa iso-8610 --> Duration

public final class ConvertitoreLatoGui {

    private static final Pattern PART =
            Pattern.compile("(\\d+)\\s*(ora|ore|h|minuto|minuti|m)");

    /**
     * Data una stringa con contenuto scritto in formato "umano" mi restituisce un oggetto inizializzato di tipo Duration.
     * @param human
     * @return Duration
     */
    public static Duration convertiStringa(String human) {
        if (human == null || human.isBlank()) {
            throw new IllegalArgumentException("Stima vuota.");
        }

        String s = human.toLowerCase(Locale.ROOT);

        long  hours = 0, minutes = 0;
        boolean found = false;

        Matcher m = PART.matcher(s);
        while (m.find()) {
            found = true;
            long value = Long.parseLong(m.group(1));
            String unit = m.group(2);

            switch (unit) {

                case "ora", "ore"         -> hours += value;
                case "minuto", "minuti"   -> minutes += value;

            }
        }

        if (!found) {
            throw new IllegalArgumentException("Formato non riconosciuto: " + human);
        }

        long totalMinutes =  minutes
                + hours * 60;

        return Duration.ofMinutes(totalMinutes); // ISO-8601 (es. PT2H30M)
    }

    //------------------------------------------------------------------------------------------

    public static String convertiDuration(Duration d) {
        if (d == null) return "";
        if (d.isZero()) return "Non impostato";
        if (d.isNegative()) return "-" + convertiDuration(d.negated());

        long seconds = d.getSeconds();

        long ore = seconds / 3600; seconds %= 3600;
        long minuti = seconds / 60; seconds %= 60;

        StringBuilder sb = new StringBuilder();
        if (ore != 0) sb.append(ore).append(ore == 1 ? " ora" : " ore");
        if (minuti != 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(minuti).append(minuti == 1 ? " minuto" : " minuti");
        }
        if (seconds != 0) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(seconds).append(seconds == 1 ? " secondo" : " secondi");
        }
        return sb.toString();
    }
}
