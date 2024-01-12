package testrunner;

import com.github.javafaker.Faker;
import config.EmployeeModel;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import utils.Utils;

import java.io.IOException;

public class PIMTestRunner extends Setup {
@BeforeTest
    public void doLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("admin","admin123");
    }
@Test(priority = 1)
    public  void createUser() throws InterruptedException, IOException, ParseException {
        PIMPage pimPage=new PIMPage(driver);

    Faker faker =new Faker();

    String firstName=faker.name().firstName();
    String lastName=faker.name().lastName();
    String userName=faker.name().username();
    String password="srottoy1234";
        pimPage.createUser(firstName,lastName,userName,password);
    Thread.sleep(4000);

    WebElement headerElement=driver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));

        String textActual=headerElement.getText();
        String textExpected="Personal Details";
        Thread.sleep(4000);
    Assert.assertTrue(textActual.equals(textExpected));

    EmployeeModel employeeModel=new EmployeeModel();

    employeeModel.setFirstName(firstName);
    employeeModel.setLastName(lastName);
    employeeModel.setUsername(userName);
    employeeModel.setPassword(password);


    Utils.saveUsers(employeeModel);

    }



}
