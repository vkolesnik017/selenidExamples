import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Main_page_logic {

    SelenideElement mark() {
        return $x("//select[@id='form_maker_id']");
    }

    SelenideElement modell() {
        return $x("//select[@id='form_model_id']");
    }

    SelenideElement motor() {
        return $x("//select[@id='form_car_id']");
    }
    SelenideElement searchBtn(){return $x("//div[@class='block-select-car__button']/a");}


    protected Main_page_logic selectCar(){
        mark().selectOptionByValue("121");
        modell().selectOptionByValue("4644");
        motor().selectOptionByValue("14881");
        searchBtn().click();

        return this;
    }
}
