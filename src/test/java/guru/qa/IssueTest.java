package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.linkText;


public class IssueTest {

    @Test
    public void testIssueSearch() throws InterruptedException {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("EldarMurzakhanov/HW11_qa_guru_Allure_Reports");
        $("#query-builder-test").submit();

        $(linkText("EldarMurzakhanov/HW11_qa_guru_Allure_Reports")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
