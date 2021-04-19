import com.codeborne.selenide.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.util.Asserts;
//import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.element;

public class PostOffice {

 @Test
    public void runFromPost() {
        open("https://mail.google.com/");
        $(byId("identifierId")).setValue("testselenide2@gmail.com");
       $(byId("identifierNext")).click();
        $(byName("password")).setValue("Lion1986");
       $ (byXpath("//span[@class='CwaK9']")).click();
       // Selenide.element(Selectors.byXpath("//div[@class='UI']")).shouldBe(visible);
        ElementsCollection letters = Selenide.elements(Selectors.byXpath("//td[@class='yX xY ']"));
        boolean found = false;

        for(int i = 0; i < letters.size(); ++i) {
            if (letters.get(i).has(text("info@pkwteile.de"))) {
                found = true;
                letters.get(i).click();
                break;
            }
        }

        if (!found) {
            System.out.println("You don't have a registration letter");
        }

       $(byXpath("//a[contains(text(),'Weiter shoppen')]")).click();
        Selenide.switchTo().window(0).close();
        Selenide.switchTo().window(0);
        $(byId("selector-wrapper")).shouldBe(visible);
        $(byName("maker_id")).selectOption(4);
        $(byName("model_id")).selectOptionByValue("308");
        $(byName("car_id")).selectOptionByValue("61");
        $(byXpath("//a[@class='submit ripple-out']")).click();

        $(byXpath("//span[@class='name'][contains(text(),'Bremsanlage')]")).click();
        $(byXpath("//span[@class='all-autoparts__itemtop-text']")).shouldBe(text("Bremsscheiben")).click();

        ElementsCollection priceList = Selenide.elements(Selectors.byXpath("//div[@class='price']"));
        System.out.println(priceList.size());
        List<Double> priceListDouble = new ArrayList();

        for(int i = 0; i < priceList.size(); ++i) {
            String correctPrice = priceList.get(i).getText().replaceAll("[^0-9,]", "").replace(",", ".");
            priceListDouble.add(Double.parseDouble(correctPrice));
        }

        List<Double> checkPriceList = new ArrayList(priceListDouble);
        Collections.sort(checkPriceList);
        if (priceListDouble.size() == checkPriceList.size()) {
            for(int el = 0; el < priceList.size(); ++el) {
                Asserts.check(priceListDouble.get(el) == checkPriceList.get(el), "Error");
            }
        } else {
            System.out.println("Quantity of prices don't match");
        }

        ElementsCollection buttonsAddToBascet = Selenide.elements(Selectors.byXpath("//div[@class='basket_btn button active_red_button ']"));
        buttonsAddToBascet.get(2).shouldHave(text("In den Warenkorb")).click();
        if (element(Selectors.byXpath("//div[@class='popup-related__header']")).is(Condition.visible)) {
            element(Selectors.byXpath("//span[@class='popup-related__close']")).click();
        }

        element(Selectors.byXpath("//div[@class='header__cart-count info artikles']")).click();
        System.out.println("Product - '" + element(Selectors.byXpath("//td[@class='info']/h3")).getText() + "' was added to basket");
        element(Selectors.byXpath("//div[@class='cart-page-head__button']")).shouldBe(new Condition[]{Condition.enabled});
        element(Selectors.byXpath("//div[@class='cart-page-head__button']")).click();
        element(byName("Email")).setValue("testselenide2@gmail.com");
        element(byName("Password")).setValue("Lion1986");
        element(Selectors.byXpath("//div[@class='button-continue']/a")).click();
        element(byName("lVorname")).setValue("testName");
        element(byName("lName")).setValue("testSurName");
        $(byName("lName"));
        $x(name("lname"));
        element(byName("lStrasse")).setValue("str. Guginhaim");
        element(byName("delivery_house")).setValue("48");
        element(byName("lPlz")).setValue("12345");
        element(byName("lOrt")).setValue("048");
        element(Selectors.byXpath("//div[@class='jq-selectbox__trigger']")).click();
        element(Selectors.byXpath("//li[contains(text(),'Deutschland')]")).click();
     SelenideElement list =    $x("//li[contains(text(),'Deutschland')]");
        element(byName("lTelefon")).setValue("200+200");
        element(Selectors.byXpath("//div[@class='button-continue address-continue']/a")).click();
        element(Selectors.byXpath("//div[contains(text(),'Vorkasse')]")).click();
        element(Selectors.byXpath("//a[contains(text(),'Weiter')]")).click();
        System.out.println(element(Selectors.byXpath("//div[@class='info-user-cart__info']")).getText());
            }

    private SelenideElement $x(String s) {
        return null;
    }

    private void $x(Condition lname) {
    }

}
