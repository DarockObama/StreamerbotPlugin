package com.streamerbot.util;

import java.util.Locale;

public class KeyFormatter {

    private KeyFormatter() {}

    /**
     * "playerKillsEnabled" -> "player kills"
     * Works for lowerCamelCase strings that end with "Enabled" (optionally).
     */
    public static String toReadableName(String lowerCamelCase) {
        if (lowerCamelCase == null) return null;

        String s = lowerCamelCase.trim();

        // Remove trailing "Enabled" if present
        if (s.endsWith("Enabled")) {
            s = s.substring(0, s.length() - "Enabled".length());
        }

        // Insert spaces before uppercase letters (keep acronyms together reasonably)
        // Examples:
        // "playerKills" -> "player Kills"
        // "playerPKKills" -> "player PK Kills"
        s = s.replaceAll("(?<=[a-z0-9])(?=[A-Z])", " ")
                .replaceAll("(?<=[A-Z])(?=[A-Z][a-z])", " ");

        s = s.toLowerCase(Locale.ROOT).replaceAll("\\s+", " ").trim();

        return s;
    }
}
