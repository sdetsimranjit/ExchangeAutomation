package Ant.qa.tradecrypto.factory;

import Ant.qa.tradecrypto.pages.Admin.AdminLandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.sql.DriverManager.getDriver;

public class DriverFactory {
public static WebDriver driver;
    public WebDriver initDriver(Properties prop)
    {
        String browserName =  prop.getProperty("browser").trim();
        System.out.println("Browser name is: " + browserName);
        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(opt);
                break;
            case "edge" : driver = new EdgeDriver();
                break;
            case "firefox" : driver = new FirefoxDriver();
                break;
            case "safari" : driver = new SafariDriver();
                break;
            default : {
                System.out.println();
                System.out.println("Please pass the correct browser ...... " + browserName);
                break;
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        String url = prop.getProperty("url");
        driver.get(url);
        return driver;
    }

    public Properties initProp()  {
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("E:\\Automation_Projects\\TradeCryptoExchange\\src\\main\\resources\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * take screenshot
     */
    public static String getScreenshot() {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    public static AdminLandingPage launchAdmin (Properties prop)
    {
        driver.switchTo().newWindow(WindowType.WINDOW);
        String adminURL = prop.getProperty("AdminURL");
        driver.get(adminURL);
        return new AdminLandingPage(driver);
    }
}
