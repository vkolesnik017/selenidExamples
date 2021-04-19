import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestWithAllure {
    @Feature("Select car in selector")
    @Step("select car")
    @Test
    public void test() {
        open("https://www.autodoc.de/");
        new Main_page_logic().selectCar();
    }
}
