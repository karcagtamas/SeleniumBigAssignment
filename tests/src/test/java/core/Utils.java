package core;

import static java.util.Objects.requireNonNull;

public class Utils {

    public static boolean stringContains(String base, String e) {
        requireNonNull(base);
        requireNonNull(e);

        return base.toLowerCase().contains(e.toLowerCase());
    }
}
