package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.dataInfo.DataInfo;
import ru.netology.operations.DatabaseOperations;
import ru.netology.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;


public class SQLTests {

    @AfterAll
    static void shouldCleanData() {
        DatabaseOperations.cleanData();
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
}

