package Features;

import Browser_Manager.DriverManagerFactory;
import Browser_Manager.DriverType;
import Common.Config;
import Elements.ElementsSelects;
import Utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.DriverManager;

public class Reportes
{
    public static WebDriver driver = null;
    Login login = new Login();
    private DriverManager driverManager;
    private static int numberOfCase = 0;
    static ExtentReports report;
    static ExtentTest test;
    SeleniumUtils utils = new SeleniumUtils();
    ElementsSelects elementsSelects = new ElementsSelects();

    @BeforeTest
    public void setUp()
    {
        numberOfCase ++;
        System.out.println("Se esta eecutando el escenario numero:" + numberOfCase);
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(Config.URL_QA);
        report = new ExtentReports("C:\\Users\\Usuario\\Desktop\\Automation\\SELENIUM\\src\\test\\java\\Features\\Reportes.java", true);
        test = report.startTest("Automation Report");


        //Login
        login.miLogin(driver);
                test.log(LogStatus.INFO, "Se realizo correctamente el Login");



    }

    @Test
    public void ListaClicks() throws Exception {

        utils.Click(elementsSelects.TapWoman(driver));
        utils.waiting(driver, 3000);

        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.waiting(driver, 2000);

        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.waiting(driver, 2000);
        utils.getScreenshot(driver, "Captura de prueba");


        //***SELECCIONAR OPCIONES CON LISTAS CON CLICK*****

        utils.Click(elementsSelects.SelectSort(driver));
        utils.waiting(driver,3800);
        String opcionEsperada = "In stock";
        String opcionBuscar = String.format("//option[text()='%s']", opcionEsperada);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        utils.Click(option);
        utils.waiting(driver,  3000);
        test.log(LogStatus.PASS, test.addScreencast(utils.getScreenshot(driver, "Screen_Uno")) +  "Se selecciona correctamente usando clicks");



    }

    @Test

    public void ListaConSendKeys(){
        utils.Click(elementsSelects.TapWoman(driver));
        utils.waiting(driver, 3000);

        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.waiting(driver, 2000);

        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.waiting(driver, 2000);

        //*****MANEJO DE LISTAS CON SEND KEYS*********
        //*****ESTA OPCION ES RECOMENDABLE************
        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver).sendKeys(opcionEsperada);
        utils.waiting(driver, 3000);
                  test.log(LogStatus.PASS, "Se selecciona correctamente usando SendKeys");



        @Test
    public void ListaUsandoClaseSelect() throws InterruptedException
    {
        utils.Click(elementsSelects.TapWoman(driver));
        utils.waiting(driver, 3000);

        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.waiting(driver, 2000);

        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.waiting(driver, 2000);

        //**********MANEJO DE LISTAS CON CLASE SELECT*******
        //**********ESTA OPCION ES LA MAS RECOMENDADA*******

        String opcionEsperada = "In stock";
        elementsSelects.SelectSort(driver);
        Select selectLista = new Select(elementsSelects.SelectSort(driver));
        //selectLista.selectByVisibleText(opcionEsperada);
        //selectLista.selectByValue("quantity:desc");
        selectLista.selectByIndex(6);
        utils.waiting(driver, 3000);
                    test.log(LogStatus.PASS, "Se selecciona correctamente usando SendKeys");

    }

    @AfterTest
    public void TearDown()
    {
        DriverManager.quitDriver();
        report.endTest(test);
        report.flush();
        

    }



}
