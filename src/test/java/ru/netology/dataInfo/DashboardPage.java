package ru.netology.dataInfo;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    void dashboardVisible(){
        $("[data-test-id=\"dashboard\"].heading").shouldHave(Condition.text("Личный кабинет"));
    }
}
