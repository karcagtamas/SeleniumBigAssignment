package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.requireNonNull;

public class Configuration {

    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null || properties.isEmpty()) {
            load();
        }

        return properties;
    }

    private static void load() {
        final var root = requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();

        Properties props = new Properties();

        try {
            props.load(new FileInputStream("%s%s".formatted(root, "app.properties")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        properties = props;
    }
}
