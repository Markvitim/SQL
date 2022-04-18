package ru.netology.pages;

import ru.netology.dataInfo.DataInfo;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public VerificationPage validAuthInfo(DataInfo info) {
        $("[data-test-id=\"login\"] input").setValue(info.getLogin());
        $("[data-test-id=\"password\"] input").setValue(info.getPassword());
        $(".button__text").click();
        return new VerificationPage();
    }
}
