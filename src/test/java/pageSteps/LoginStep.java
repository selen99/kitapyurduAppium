package pageSteps;

import com.thoughtworks.gauge.Step;
import pages.LoginPage;

public class LoginStep {
    LoginPage loginPage = new LoginPage();

    @Step("Close the pop up if it appears")
    public void closePopUp() throws InterruptedException {
        if (loginPage.checkElement(loginPage.notificationALERT, 10)) {
            loginPage.doubleClick(loginPage.notificationDenyBTN, 3);
        }
    }

    @Step("Click to my account")
    public void clickToMyAccount() {
        loginPage.click(loginPage.myAccountBTN);
    }

    @Step("Type e-mail <email>")
    public void typeEmail(String email) {
        loginPage.writeToElement(loginPage.emailINPUT, email);
    }

    @Step("Type password <password>")
    public void typePassword(String password) {
        loginPage.writeToElement(loginPage.passwordINPUT, password);
    }

    @Step("Click to giris yap button")
    public void clickToGirisYap() {
        loginPage.click(loginPage.girisYapBTN);
    }

    @Step("Control warning message")
    public void controlWarningMessage() {
        loginPage.checkElement(loginPage.warningMessageALERT, 10);
    }

    @Step("Click to tamam button")
    public void clickTamamButton() {
        loginPage.click(loginPage.tamamBTN);
    }

    @Step("Control that you login the app")
    public void controlLoginOperation() {
        loginPage.control(loginPage.controlTXT, "Emre Konyar");
    }

    @Step("Reset password area")
    public void deleteOldPasswordInput() {
        loginPage.click(loginPage.emailDeleteBTN);
    }

    @Step("Reset e-mail area")
    public void deleteOldEmailInput() {
        loginPage.click(loginPage.emailDeleteBTN);
    }
}
