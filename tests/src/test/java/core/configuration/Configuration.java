package core.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null || properties.isEmpty()) {
            load();
        }

        return properties;
    }

    public static String getProperty(ConfigKey key) {
        return getProperties().getProperty(key.getKey());
    }

    private static void load() {
        Properties props = new Properties();

        try (var inputStream = new FileInputStream("app.properties")) {
            props.load(inputStream);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        properties = props;
    }
}
