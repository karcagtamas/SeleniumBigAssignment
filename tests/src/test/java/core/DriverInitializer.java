package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DriverInitializer {

    public static WebDriver initialize(String url) throws MalformedURLException, URISyntaxException {
        return initialize(new URI(url).toURL());
    }

    public static WebDriver initialize(URL url) {
        final var driver = new RemoteWebDriver(url, new ChromeOptions());
        driver.manage().window().maximize();

        return driver;
    }
}
