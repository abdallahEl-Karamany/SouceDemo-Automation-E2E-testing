package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions {

    private static ThreadLocal<WebDriver> localDriver=new ThreadLocal<>();


    public static void webDriverInit(browser Browser){

        switch (Browser){

            case chrome:
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--incognito"); // Avoids triggering profile-level alerts
                localDriver.set(new ChromeDriver(option));
                break;
            case edge:localDriver.set(new EdgeDriver());
                break;
            case firefox:localDriver.set(new FirefoxDriver());
            break;
        }
    }

    public static void windowMaximize(){
        localDriver.get().manage().window().maximize();
    }
    public static void closeBrowser(){
        localDriver.get().quit();
    }
    public static WebDriver getDriver(){return localDriver.get();}

    public enum browser{
        chrome,
        edge,
        firefox


    }


}
