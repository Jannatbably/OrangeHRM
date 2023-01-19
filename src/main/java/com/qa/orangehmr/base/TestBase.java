package com.qa.orangehmr.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

   public WebDriver driver;
   public Properties pro;
   public FileInputStream file;

    public void driver_init() throws IOException {

         pro=new Properties();
         file=new FileInputStream("C:\\Users\\motin\\IdeaProjects\\OrangeHMRFramework\\src\\main\\java\\com.qa.orangehmr.config\\config.properties");
        pro.load(file);
        pro.getProperty("browser_Name");
        pro.getProperty("url");

        String browser_name="chorme";

        if(browser_name.equalsIgnoreCase("Chorme")){
             driver=new ChromeDriver();
        } else if (browser_name.equalsIgnoreCase("FireFox")){
             driver=new FirefoxDriver();
        } else if (browser_name.equalsIgnoreCase("Edge")){
             driver=new EdgeDriver();
        } else if (browser_name.equalsIgnoreCase("safari")){
             driver=new SafariDriver();
        }else{
            System.out.println("please provide current browser name ");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(pro.getProperty("url"));



    }


    public static void main(String[] args) throws IOException {

        TestBase tb=new TestBase();
        tb.driver_init();

    }

























}
