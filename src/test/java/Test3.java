import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertFalse;

public class Test3 {
    {
        Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Abgasanlage"}, {"Achsantrieb"}, {"Anhänge- / Zugvorrichtung"}, {"Artikelsuche über Grafik"}, {"Ausstattung / Zubehör"}};
    }

    @Test(dataProvider = "data-provider")
    public void testMethod(String data) {
        open("https://lkwteile.autodoc.de/");
        $x("//div[@class='header__main']").shouldBe(visible);

        ElementsCollection carBrand = $$x("//div[@class='truck-home-cars__image']");

        carBrand.get(1).click();
        pageLoader();
        ElementsCollection marks = $$x("//div[@class='lkw_top_models']/ul/li/a");

        marks.shouldHave(sizeGreaterThan(10));
        System.out.println();

       /* $x("//a[@class='menu-catalog__enter--disabled js-menu-catalog__enter-lkw menu-catalog__enter-lkw']").click();
        $x("//div[@class='menu-category__block']").shouldBe(visible);
        *//*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*//*
        ElementsCollection categories = $$x("//li[contains(@class,'menu-category__first-item')]");
        ElementsCollection activcategoryOfSecondBlock = $$x("//div[@class='menu-category__2-block']//li[contains(@class,'menu-category__item')]/span/span").filter(visible);
        ElementsCollection activeCategoryOfThirdBlock = $$x("//div[@class='menu-category__3-block']//li[@class='menu-category__item']").filter(visible);
        SelenideElement thirdBlock = $x("//div[@class='menu-category__3-block']");
       for (int i = 0; i < categories.size(); i++) {
            $x("//a[contains(text(),'" + data + "')]").scrollIntoView("{block: \"end\"}").hover();
            $x("//div[@class='menu-category__2-block']").should(appear);

         if (activcategoryOfSecondBlock.get(0).isDisplayed()) {
                for (int j = 0; j < activcategoryOfSecondBlock.size(); j++) {
                    activcategoryOfSecondBlock.get(j).scrollIntoView("{block: \"end\"}").hover();
                    thirdBlock.should(appear);
                    activeCategoryOfThirdBlock.shouldHave(sizeNotEqual(0));
            }
            }
     }
*/
    }

    public void pageLoader() {
        Wait().until(webDriver -> executeJavaScript("return document.readyState").equals("complete"));
    }

}
