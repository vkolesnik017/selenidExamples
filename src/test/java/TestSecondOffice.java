import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSecondOffice {
@Test
    public void checkTest() {
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
    }
}
