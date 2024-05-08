package core.configuration;

public enum ConfigKey {
    BROWSER("browser"),
    URL("url"),
    USERNAME("username"),
    PASSWORD("password");

    private final String key;

    ConfigKey(String key) {

        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
