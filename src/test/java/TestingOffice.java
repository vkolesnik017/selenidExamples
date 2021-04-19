import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.*;
//@ExtendWith({SoftAssertsExtension.class})
public class TestingOffice {

    {
        Configuration.holdBrowserOpen = true;
    }

   @Test
    public void testing(){
        Configuration.assertionMode= AssertionMode.SOFT;
        open("https://getnada.com/msg");

        $(byXpath("//div[@class='amg']")).shouldBe(visible);
//        $(byId("mail")).shouldHave(text("@"));
        //  System.out.println($(byId("mail")).getText());
        //  $(byText("Add Inbox")).shouldBe(visible);
        $(byXpath("//i[@class='icon-plus']")).click();
        $(byXpath("//div[@class='modal-content open']")).shouldBe(Condition.visible);
        $(byXpath("//input[@class='user_name']")).setValue("zxalrttyla");
        $(byXpath("//a[@class='button success']")).click();
        String emailAdres = $(byXpath("//span[@class='address what_to_copy']")).getText();
        System.out.println(emailAdres);
        //   switchTo().window(1);
        open("https://www.pkwteile.de/");
        $(byXpath("//span[@class='status ga-click']")).click();
        $(byId("reg_pop")).click();
        $(byId("email")).setValue(emailAdres);
        $(byId("Password")).setValue("12345678");
        $(byId("new_pass_confirm")).setValue("12345678");
        $("#register_form > fieldset > div.accept_subscription_checkbox.subscribe_checkbox > label").click();
        $(byXpath("//a[@class='register_submit']")).click();
        Selenide.element("#login_complete > div.btns > div:nth-child(2) > a").shouldHave(new Condition[]{Condition.text("Weiter einkaufen")}).click();
        $(byId("login_complete")).shouldBe(Condition.disappear);
        back();
        back();
        refresh();
        $("#app > div:nth-child(1) > div.wrapper > div.sidebar > div > div.panel-body > nav > h3").shouldBe(visible);
        $(withText("Willkommen an Bord")).click();
        $(byText("Weiter shoppen")).click();
        Selenide.switchTo().window(0).close();
        Selenide.switchTo().window(0);

    }

}
