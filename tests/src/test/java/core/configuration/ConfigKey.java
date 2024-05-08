package core.configuration;

public enum ConfigKey {
    BROWSER("browser"),
    URL("url"),
    EMAIL("email"),
    PASSWORD("password");

    private final String key;

    ConfigKey(String key) {

        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
