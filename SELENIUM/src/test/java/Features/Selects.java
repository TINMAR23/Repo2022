package Features;

import Common.BaseTest;
import Elements.ElementsSelects;
import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;
import org.testng.util.Strings;


public class Selects extends BaseTest {

    SeleniumUtils utils = new SeleniumUtils();
    ElementsSelects elementsSelects = new ElementsSelects();

    @Test
    public void ListaClicks() {

        utils.Click(elementsSelects.TapWoman(driver));
        utils.waiting(driver, 3000);

        utils.Click(elementsSelects.BottonMasTops(driver));
        utils.waiting(driver, 2000);

        utils.Click(elementsSelects.BottonTSshirts(driver));
        utils.waiting(driver, 2000);

        //***SELECCIONAR OPCIONES CON LISTAS CON CLICK*****
        
        utils.Click(elementsSelects.SelectSort(driver));
        utils.waiting(driver,3800);
        String opcionEsperada = "In stock";
        String opcionBuscar = String.format("//option[text()='%s']", opcionEsperada);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        utils.Click(option);
        utils.waiting(driver,  3000);

        

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


    }

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

    }






}














