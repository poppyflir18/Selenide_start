package selenide;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ToDoTest {
    @Test
    void ToDoTest(){
        Configuration.timeout =6000;
        Configuration.browser= Browsers.CHROME;
        open("https://todomvc.com/examples/emberjs/");
        $("#new-todo").shouldBe(visible).setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        $("#new-todo").setValue("c").pressEnter();

        $$("#todo-list>li").shouldHave(exactTexts("a", "b" ,"c"));
        $$("#todo-list>li").findBy(exactText("b")).find(".toggle").click();
        $$("#todo-list>li").filterBy(cssClass("completed")).shouldHave(exactTexts("b"));
        $$("#todo-list>li").filterBy(not(cssClass("completed"))).shouldHave(exactTexts("a","c"));


    }
}
