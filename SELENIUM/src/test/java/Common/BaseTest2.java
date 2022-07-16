package Common;

import Browser_Manager.DriverManager;
import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest2
{
    //*******INSTANCIAS********
    public static WebDriver driver = null;
    private DriverManager driverManager;
    private static int numberofcase = 0;

    //*******************

    @BeforeTest
    public void beforeTestMethod() throws Exception
    {
        numberofcase ++;
        System.out.println("Se esta ejecutando el escenario numero"+ numberofcase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_AMZ);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterTest
    public void TeardDown()
    {

        System.out.println("El escenario numero" + numberofcase + "Se ejecuto correctamente");
        driverManager.quitDriver();
    }





}
