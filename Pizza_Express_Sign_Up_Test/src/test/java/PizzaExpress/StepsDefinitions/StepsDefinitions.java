package PizzaExpress.StepsDefinitions;

import PizzaExpress.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepsDefinitions extends DriverManager {

    public String expectedText = "CREATE AN ACCOUNT";
    public String finalExpectedText = "ROB'S PIZZAEXPRESS";


    @Given("User is on main page")
    public void userIsOnMainPage() {
        startDriver();
        driver.get("https://www.pizzaexpress.com/");
        WebElement acceptCookies = driver.findElement(By.cssSelector("#root > section.cookie-banner > div > div > button"));
        acceptCookies.click();

    }

    @When("User clicks Sign up button")
    public void userClosesPopUpWindow() {
        WebElement signUpButton = driver.findElement(By.cssSelector("#interstitial-overlay > div > div > a"));
        signUpButton.click();
    }

    @Then("User should see page with CREATE AN ACCOUNT sign")
    public void createANACCOUNTPageShouldBeOpen() {

        String registrationPageAuthentication = driver.findElement(By.cssSelector("#hero-copy > div > div > h2")).getText();
        assertThat("Expected text should be: " + expectedText + " and visible one is: " + registrationPageAuthentication, expectedText.equalsIgnoreCase(registrationPageAuthentication));
    }

    @Given("Pizza Express registration page is open")
    public void pizzaExpressRegistrationPageIsOpen() {
        String registrationPageAuthentication = driver.findElement(By.cssSelector("#hero-copy > div > div > h2")).getText();
        assertThat("Expected text should be: " + expectedText + " and visible one is: " + registrationPageAuthentication, expectedText.equalsIgnoreCase(registrationPageAuthentication));
    }

    @Then("User chooses Title from dropdown list")
    public void userChoosesTitleFromDropdownList() {
        WebElement TitleList = driver.findElement(By.id("register_title"));
        Select TitleDropDownList = new Select(TitleList);
        TitleDropDownList.selectByVisibleText("Mr");
    }

    @And("User writes {string} in First name input field")
    public void userWritesNameInFirstNameInputField(String userName) {
        WebElement nameField = driver.findElement(By.name("firstname"));
        nameField.sendKeys(userName);
    }

    @And("User writes {string} in Last name input field")
    public void userWritesSurnameInLastNameInputField(String userSurname) {
        WebElement surnameField = driver.findElement(By.name("surname"));
        surnameField.sendKeys(userSurname);
    }

    @And("User writes {string} in Email address input field")
    public void userWritesEmailInEmailAddressInputField(String userEmail) {
        WebElement emailField = driver.findElement(By.id("register_email"));
        emailField.sendKeys(userEmail);
    }

    @And("User writes {string} number in Mobile input field")
    public void userWritesMobileNumberInMobileInputField(String userMobile) {
        WebElement mobileField = driver.findElement(By.name("mobile"));
        mobileField.sendKeys(userMobile);
    }

    @And("User writes {string} in Date of birth input field")
    public void userWritesDateInDateOfBirthInputField(String userDate) {
        WebElement dateOfBirthField = driver.findElement(By.name("dob"));
        dateOfBirthField.sendKeys(userDate);
    }

    @And("User writes {string} in Postcode input field")
    public void userWritesPostcodeInPostcodeInputField(String postcode) {
        WebElement postcodeField = driver.findElement(By.name("postcode"));
        postcodeField.sendKeys(postcode);
    }

    @And("User writes {string} in Create password inout field")
    public void userWritesPasswordInCreatePasswordInoutField(String userPassword) {
        WebElement passwordField = driver.findElement(By.id("register_password"));
        passwordField.sendKeys(userPassword);
    }

    @And("User ticks Terms&Conditions information box")
    public void userTicksTermsConditionsInformationBox() {
        WebElement TermsAndConditionsBox = driver.findElement(By.id("register_tandc"));
        TermsAndConditionsBox.click();
    }

    @And("User ticks offers and news information box")
    public void userTicksOffersAndNewsInformationBox() {
        WebElement offersBox = driver.findElement(By.id("signup_optin"));
        offersBox.click();
    }

    @And("User clicks Create my account button or log in")
    public void userClicksCreateMyAccountButton() throws InterruptedException {
        WebElement CreateAnAccountButton = driver.findElement(By.cssSelector("#root > div:nth-child(7) > div:nth-child(2) > div > signup-form > section > div > form > button"));
        CreateAnAccountButton.click();
        Thread.sleep(2000);
        if(driver.findElement(By.cssSelector("#root > div:nth-child(7) > div:nth-child(2) > div > signup-form > section > div > form > div.input-group.is-col-4.is-col-6-touch.is-col-12-mobile.txt-center > p")).isDisplayed()) {
            WebElement loginButton = driver.findElement(By.cssSelector("#root > div:nth-child(7) > div:nth-child(2) > div > signup-form > section > div > form > div.input-group.is-col-4.is-col-6-touch.is-col-12-mobile.txt-center > p > a"));
            loginButton.click();
            WebElement emailLoginInputField = driver.findElement(By.cssSelector("#login_email"));
            emailLoginInputField.sendKeys("autotesting74@yahoo.com");
            WebElement passwordLoginInputField = driver.findElement(By.cssSelector("#login_password"));
            passwordLoginInputField.sendKeys("Testing2321");
            WebElement yellowLoginButton = driver.findElement(By.cssSelector("#root > div:nth-child(7) > div:nth-child(2) > div > section > div > form > button"));
            yellowLoginButton.click();
        } else {
            System.out.println("User created successfully");
        }
    }

    @Then("User should see ROB'S PIZZAEXPRESS sign")
    public void userShouldSeeHisNameCombinedWithPizzaExpressNameAtTheTop(){
        String createdAccountNameWithPizzaExpress = driver.findElement(By.cssSelector("#my_pizzaexpress_header > div > div > h1")).getText();
        assertThat("Expected text should be: " + finalExpectedText + " and the one visible is: " + createdAccountNameWithPizzaExpress, finalExpectedText.equalsIgnoreCase(createdAccountNameWithPizzaExpress));
        destroyDriver();
    }





    @Given("Yahoo website is open")
    public void yahooWebsiteIsOpen() {
        startDriver();
        driver.get("https://uk.mail.yahoo.com");
    }

    @When("User writes {string} into the email input field")
    public void userWritesEmailIntoTheEmailInputField(String userEmail) {
        WebElement usernameField = driver.findElement(By.id("login-username"));
        usernameField.sendKeys(userEmail);
    }

    @And("User clicks Next button")
    public void userClicksNextButton() {
        WebElement nextButton = driver.findElement(By.id("login-signin"));
        nextButton.click();
    }

    @Then("Password request page should be open")
    public void passwordRequestPageShouldBeOpen() {
        String expectedPasswordPageText = "Password";
        String actualPasswordPageText = driver.findElement(By.id("password-label")).getText();
        assertThat("Expected text should be: " + expectedPasswordPageText + " and visible is: " + actualPasswordPageText, expectedPasswordPageText.equalsIgnoreCase(actualPasswordPageText));
    }

    @Then("User writes {string} into password input field and clicks Next button")
    public void userWritesPasswordIntoPasswordInputField(String userEmailPassword) {
        WebElement passwordInputField = driver.findElement(By.id("login-passwd"));
        passwordInputField.sendKeys(userEmailPassword);
    }

    @And("User clicks Next button after typing password")
    public void userClicksNextButtonAfterPassword() {
        WebElement passwordNextButton = driver.findElement(By.name("verifyPassword"));
        passwordNextButton.click();
    }

    @Then("Main Inbox page should be open")
    public void mainInboxPageShouldBeOpen() {
        String expectedFirstMenuOption = "Compose";
        String actualFirstMenuOption = driver.findElement(By.cssSelector("#app > div.I_ZnwrMC.D_F.em_N.o_h.W_6D6F.H_6D6F > div > div.a_3rehn.W_3o4BO.s_3o4BO.cZ10Gnkk_ZM1sUU.D_F.ek_BB.em_0 > nav > div > div:nth-child(1) > a")).getText();
        assertThat("Expected text should be: " + expectedFirstMenuOption + " and visible is: " + actualFirstMenuOption, expectedFirstMenuOption.equalsIgnoreCase(actualFirstMenuOption));
    }


    @When("User clicks on the email from Pizza Express")
    public void userClicksOnTheEmailFromPizzaExpress() throws InterruptedException {
        do {
            Thread.sleep(5000);
            driver.navigate().refresh();
            Thread.sleep(5000);
        } while (driver.findElements(By.xpath("//a[@role='article']")).isEmpty());

            WebElement email = driver.findElement(By.cssSelector("#mail-app-component > div > div > div.D_F.ab_FT.em_N.ek_BB.iz_A.H_6D6F > div > div > div.W_6D6F.H_6D6F.cZ1RN91d_n.o_h.p_R.em_N.D_F > div > div.p_R.Z_0.iy_h.iz_A.W_6D6F.H_6D6F.k_w.em_N.c22hqzz_GN > ul > li:nth-child(2) > a"));
            email.click();
    }

    @Then("User should see an open Email with {string} notification in the middle")
    public void userShouldSeeAnOpenEmailWithNotificationInTheMiddle(String confirmationText) throws InterruptedException {
        String actualVisibleText = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/ul/li/div/div/div[1]/div[2]/div/div/div/div/center/table[3]/tbody/tr/td/table/tbody/tr/td/div/div/table/tbody/tr/td/table/tbody/tr[1]/td/h2")).getText();
        assertThat("Part of expected text in received email should be: " + confirmationText + " and the actual one is: " + actualVisibleText, confirmationText.equalsIgnoreCase(actualVisibleText));
        Thread.sleep(2000);
        destroyDriver();
    }

}
