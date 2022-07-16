package Features;

import Common.BaseTest3;
import Elements.ElementsDragAndDrop;
import Utils.SeleniumUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseTest3
{

    SeleniumUtils utils = new SeleniumUtils();
    ElementsDragAndDrop elementsDragAndDrop = new ElementsDragAndDrop();

    @Test
    public void DragAndDrop()
    {
        Actions action = new Actions(driver);
        utils.Click(elementsDragAndDrop.OptionDroppable(driver));

        driver.switchTo().frame(0);
        action.clickAndHold(elementsDragAndDrop.Drag(driver))
                .moveToElement(elementsDragAndDrop.Drop(driver))
                .release()
                .build()
                .perform();
        utils.waiting(driver, 3000);




    }





}
