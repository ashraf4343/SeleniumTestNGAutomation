import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PIMTestRunner extends Setup {
@BeforeTest
    public void doLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("admin","admin123");
    }
@Test(priority = 1)
    public  void createUSer() throws InterruptedException {
        PIMPage pimPage=new PIMPage(driver);
        pimPage.createUser("samal","sudu","samal1234","srottoy1234");
    Thread.sleep(4000);

    WebElement headerElement=driver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));

        String textActual=headerElement.getText();
        String textExpected="Personal Details";
        Thread.sleep(4000);
    Assert.assertTrue(textActual.equals(textExpected));

    }



}
