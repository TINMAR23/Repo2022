package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Asserts
{
    private WebDriver driver;

    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(9000);


    }

    @Test
    public void AsseertTrue()
    {
        //El Asseert True se utiliza para realizar validaciones para scripts positivas

        WebElement user = driver.findElement(By.id("mail"));
        WebElement password = driver.findElement(By.id("passContainer"));

        //Se valida que los elementos esten presentes,lo cual nos dara como resultado que los scripts sean pasados.

        Assert.assertTrue(user.isDisplayed());
        Assert.assertTrue(password.isDisplayed());

    }

    @Test
    public void AssertFalse() throws InterruptedException {
        //El Asseert False se utiliza para realizar validaciones para scripts negativos

        WebElement user = driver.findElement(By.id("mail"));
        WebElement password = driver.findElement(By.id("passContainer"));

        user.sendKeys("ardillapuma@hotmail.com");
        Thread.sleep(3000);
        password.sendKeys("iweroiueoiuer");
        Thread.sleep(3000);
        password.submit();
        Thread.sleep(3000);
        WebElement mensaje = driver.findElement(By.xpath("//div[contains(text(), 'Contraseña incorrecta')]"));
        //Assert.assertTrue(mensaje.isDisplayed());
        Assert.assertFalse(mensaje.isDisplayed());



        //Se puede validar algun boton, mensaje de error, etiquetas, para que nuestro test sea fallido
        //Assert.assertFalse(user.isDisplayed());
    }

    @Test
    public void AssertEquals() throws InterruptedException
    {
        //El Assert Equals realiza validaciones de igualdad
        String expectedtitle = "Iniciar sesión en Facebook";
        Thread.sleep(1000);
        Assert.assertEquals(expectedtitle, driver.getTitle());
    }

    @Test
    public void GetText()
    {
        //Con los metodos Get, podemos recuperar informacion y guardarlo en una variable

        String CreateAccount = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).getText();
        //String messageFacebook = driver.findElement(By.xpath("//h2[contains(text(), 'Facebook te ayuda a comunicarte y compartir con las personas que forman parte de tu vida.')]")).getText();
        Assert.assertEquals(CreateAccount, "Crear cuenta nueva");
        Assert.assertEquals(CreateAccount.length(), 17);
    }

    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();
    }




}
