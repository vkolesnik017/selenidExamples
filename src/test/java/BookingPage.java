import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.apache.http.util.Asserts;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
//@ExtendWith({SoftAssertsExtension.class})
public class BookingPage {
  @BeforeTest
    public static void setup() {
        Configuration.holdBrowserOpen = true;
        Configuration.assertionMode= AssertionMode.SOFT;
        Configuration.timeout=6000;
    }
@Test
    public void test(){
        open("https://www.booking.com/");
        $(byId("ss")).setValue("Рим");
        ElementsCollection dropMenu = $$(byXpath("//li[contains(@class,'c-autocomplete__item')]"));
        dropMenu.get(1).shouldBe(visible).click();
        $(byXpath("//div[@class='bui-calendar__content']")).shouldBe(visible);
        $(byXpath("//div[@class='bui-calendar__content']/div[1]//span[contains(text(),'21')]")).click();
        $(byXpath("//div[@class='bui-calendar__content']/div[1]//span[contains(text(),'31')]")).click();
        $(byText("Проверить цены")).click();
        if ($(byXpath("//div[@class='map_with_list__container ']")).has(appear)) {
            $(byXpath("//div[@class='map_full_overlay__close']")).click();
        }
        $(byXpath("//li[contains(@class,'sort_price ')]")).should(exist).click();
     //   $(byText("Получите доступ")).shouldBe(visible);
     //   $(byText("Получите доступ")).shouldNotBe(visible);
       $(byXpath("//div[@id='sr_notice_no_dorms']")).should(appear);

        ElementsCollection priceWithValue = $$(byXpath("//div[@class='bui-price-display__value prco-inline-block-maker-helper']"));

        List<Integer> currentPrice = new ArrayList<>();
        for (int i=0; i<priceWithValue.size(); i++) {
            String ss = priceWithValue.get(i).getText().replaceAll("[A-Z]","").replaceAll(" ","");
      currentPrice.add(Integer.parseInt(ss));
        }



        int minPrice = Collections.min(currentPrice);
        System.out.println("Минимальная цена - " + minPrice);
        System.out.println("Первая цена - " +currentPrice.get(0));

        Asserts.check(minPrice==currentPrice.get(0),"Мин цена не соответствует");
    }
}
