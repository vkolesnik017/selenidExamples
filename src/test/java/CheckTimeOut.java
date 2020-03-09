import com.codeborne.selenide.*;
import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.impl.CollectionElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.apache.http.util.Asserts;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.text.DefaultStyledDocument;
import javax.xml.bind.Element;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

//@ExtendWith({SoftAssertsExtension.class})
public class CheckTimeOut {

  //  private int s;




    {
        Configuration.timeout=6000;
        Configuration.assertionMode= AssertionMode.SOFT;
        Configuration.startMaximized=true;
        Configuration.holdBrowserOpen = true;
     //   Configuration.browserCapabilities=close();
        Configuration.browserCapabilities.setCapability("disable-infobars",true);
        Configuration.browserCapabilities.setCapability("disable-notification",true);
        Configuration.browserCapabilities.setCapability("enableVNC", true);


    }

@Test
    public void test () {
//    String anotherPalindrome = "nagara. O roar again!".toUpperCase();
//    String name ="Ivanov".toUpperCase();
//    char nameLetter = name.charAt(0);
//    char aChar = anotherPalindrome.charAt(0);
//    System.out.println("Dear, " + aChar+". " +nameLetter+".");

    System.out.println("dear, " +checkName("ivanod")+ checkName("Sidorov"));
/*    ChromeOptions options = new ChromeOptions();
    options.addArguments("disable-notification");
    options.addArguments("disable-infobars");
    DesiredCapabilities caps = DesiredCapabilities.chrome();
   caps.setCapability(ChromeOptions.CAPABILITY, options);

    Configuration.browser = "chrome";
    Configuration.browserCapabilities = caps;*/


  //  open("https://google.com");      // NB! Infobar is visible! Like `disable-infobars` didn't work.
   // sleep(3000);
//open("https://www.pkwteile.de/autoteile/bmw-ersatzteile/1-cabriolet-e88/32175/10132/bremsscheibe");

  //  $(byXpath("//div[contains(text(),'Бренд'))")
          //  $(byXpath("//div[contains(text(),'Бренд')]")).scrollTo();
   // $(byXpath("//div[contains(text(),'Тип кондиционера')]")).shouldBe(visible);
//    $(byXpath("//div[contains(text(),'Produktreihe')]")).scrollTo();
//ElementsCollection ss = $$(byXpath("//div[contains(text(),'Produktreihe')]/following-sibling::div//div[@class='sb_checkbox_box show-first']")).filterBy(visible);
//    System.out.println(ss.size());
//    ElementsCollection s = $$(byXpath("//div[contains(text(),'Produktreihe')]/following-sibling::div//div[@class='sb_checkbox_box show-first']"));
//    System.out.println(s.size());
//    ss.get(8).click();
//   for (SelenideElement el: ss) {
//
//    }
//   switchTo().alert().dismiss();
//ss.get(3).click();
//$(byXpath("//div[@class='block-cookies__close']")).shouldBe(visible).click();
//ElementsCollection ss = $$(byXpath("//*[@class='basket_btn button active_red_button ']"));
//ss.get(2).click();

//$(byXpath("/html/body/app-root/div/div[1]/div[1]/header/div/div[2]/div[1]/button/span")).shouldHave(text("hello"));
//$(byXpath("/html/body/app-root/div/div[1]/div[1]/header/div/div[1]/div[2]/div/span")).shouldHave(text("ho"));
//$(byXpath("//select[@class='select-css additional-service__select ng-pristine ng-valid ng-touched']")).shouldBe(visible);
  //  System.out.println($(byXpath("//select[@class='select-css additional-service__select ng-pristine ng-valid ng-touched']")).getText());
 //   $(withText("Предназначение устройства")).scrollTo();

//
//    $(byId("name")).shouldBe();
//    System.out.println("hello");
//    $("#td").parent();

/*$(byXpath("//div[@class='filter-active']")).shouldBe(visible);

if ($(byName("drop_link")).has(text("новинки"))) {
    System.out.println("всё норм");
   } else {
    System.out.println("всё НЕ норм");
    $(byName("drop_link")).click();
    $(byId("filter_sortnovelty")).shouldBe(visible);
    $(byId("filter_sortnovelty")).click();*/
   // switchTo().alert().dismiss();
}

public String checkName (String name) {
    String s =name.toUpperCase();
    char nameLetter = name.charAt(0);
    return nameLetter+".";
}
    }
//}
