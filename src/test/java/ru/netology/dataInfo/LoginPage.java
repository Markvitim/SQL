package ru.netology.dataInfo;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public VerificationPage validAuthInfo(DataInfo info) {
        $("[data-test-id=\"login\"] input").setValue(info.getLogin());
        $("[data-test-id=\"password\"] input").setValue(info.getPassword());
        $(".button__text").click();
        return new VerificationPage();
    }
}
