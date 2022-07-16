package Features;

import Common.BaseTest;
import Utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Alertas extends BaseTest {

    WebDriverWait wait;
    SeleniumUtils utils = new SeleniumUtils();


    @Test
    public void Alerts ()
    {
       //********INSTANCIA DE OBJETO JAVA SCRIP********
        JavascriptExecutor js = (JavascriptExecutor) driver;

      //ACEPTAR ALERTAS******
        js.executeScript("alert('EL EDHER GAY Y LE VA AL AMERICA');");
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
       /* driver.switchTo().alert().accept();
        utils.waiting(driver, 3000);*/

        //DISMIS ALERTA ----> lo que hace esta en funcion es cancelar la alerta********

        String alert = driver.switchTo().alert().getText();
        System.out.println("TEXTO DE ALERTA; " + alert);
        utils.waiting(driver, 6000);
        driver.switchTo().alert().dismiss();




    }








}
