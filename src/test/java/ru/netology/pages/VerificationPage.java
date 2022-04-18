package ru.netology.pages;


import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    public DashboardPage verifyCode(String verificationCode) {
        $("[data-test-id=\"code\"] input").setValue(verificationCode);
        $("[data-test-id=action-verify]").click();
        return new DashboardPage();
    }
}
