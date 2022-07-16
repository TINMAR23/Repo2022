package Features;

import Common.BaseTest2;
import Elements.ElementsAmazon;
import Utils.SeleniumUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClaseActions extends BaseTest2
{

 SeleniumUtils utils = new SeleniumUtils();
 ElementsAmazon elementsAmazon = new ElementsAmazon();

    @Test
    public void MoveToElement()
    {
        //******ESTE CODIGO ES PARA MOVER EL MOUSE
        Actions action = new Actions(driver);
        action.moveToElement(elementsAmazon.MenuPrime(driver)).build().perform();
        utils.waiting(driver,4000);

        action.moveToElement(elementsAmazon.BotonAmazonPrime(driver)).build().perform();
        utils.waiting(driver, 2000);
        action.click().build().perform();
        utils.waiting(driver, 4000);

    }

}
