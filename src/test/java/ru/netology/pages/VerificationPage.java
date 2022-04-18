package ru.netology.pages;

import ru.netology.pages.DashboardPage;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    public DashboardPage verifyCode(String verificationCode) {
        $("[data-test-id=\"code\"] input").setValue(verificationCode);
        $("[data-test-id=action-verify]").click();
        return new DashboardPage();
    }
}
