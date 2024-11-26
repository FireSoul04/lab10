package it.unibo.mvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigFileParser {

    private final Map<String, String> parsedConfig;

    public ConfigFileParser(final String configPath) {
        List<String> lines = List.of();
        try {
            lines = Files.readAllLines(Path.of(configPath));
        } catch (IOException e) {
            System.out.println(e); // NOPDM: exercise
            System.exit(0);
        }
        this.parsedConfig = new HashMap<>();
        lines.forEach(s -> {
            final String[] tokens = s.split(": ");
            this.parsedConfig.put(tokens[0], tokens[1]);
        });
    }

    public String get(final String key) {
        return this.parsedConfig.get(key);
    }
}
