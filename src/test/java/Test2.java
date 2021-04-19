import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Locatable;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.stream.Location;
import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;


public class Test2 {

    SelenideElement oemBlock() {
        return $x("//div[@class='product-info-block__oem']");
    }

    SelenideElement description() {
        return $x("//div[@class='product-block__description__wrap']");
    }

    ElementsCollection links() {
        return $$x("//a[@class='product-tabs__item js-tab-scroll-to']");
    }

    {
        // Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        ChromeOptions options = new ChromeOptions();

    }
    @Test
    public void test() throws IOException {
        open("https://www.mailinator.com/");

        $(".input-group input").shouldBe(visible).setValue("qc_testfortest_autotest@mailinator.com").pressEnter();
        $x("//*[contains(text(),'info@autodoc.de')]").shouldBe(visible).click();
     //   $(byId("pills-links-tab")).shouldBe(visible).click();
        $x("//td[@class='es-footer-body-text']//a").shouldBe(visible).click();
        System.out.println();

    }


}
