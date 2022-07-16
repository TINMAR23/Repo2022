package Features;

import Common.BaseTest;
import Elements.ElementsLogin;
import Utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Waits extends BaseTest
{
        ElementsLogin elementsLogin = new ElementsLogin();
        SeleniumUtils utils = new SeleniumUtils();
    @Test
    public void waits ()
    {
        //******** IMPLICIT WAIT *******

        // Esta espera se utiliza para dar oportunidad a que cargue el navegador
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //*****EXPLICIT WAIT*****//
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(elementsLogin.tapWomen));
        utils.Click(elementsLogin.TapWomen(driver));


    }



}
