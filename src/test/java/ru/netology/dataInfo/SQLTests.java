package ru.netology.dataInfo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SQLTests {
    @Test
    void shouldGetVerificationCode() {
        DatabaseOperations.getVerificationCode();
    }

    @Test
    void shouldGetDashboardPage() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
        var verificationPage = loginPage.validAuthInfo(new DataInfo());
        var dashboardPage = verificationPage.verifyCode(DatabaseOperations.getVerificationCode());
        dashboardPage.dashboardVisible();
    }

    @Test
    void shouldCleanData() {
        DatabaseOperations.cleanData();
    }
}

