package selenide;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
    @Test
    public void GoogleSearch(){
        open("https://www.google.com");
        $(By.name("q")).setValue("Selenide").pressEnter();
        $("#search h1").shouldHave(text("Search Results"));
        $$("#search #rso .g").shouldHave(sizeGreaterThan(5));
    }
}
