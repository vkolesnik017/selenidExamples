package qc;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class Category_oen_page {

    ElementsCollection listProducts() {return $$x("//ul[@class='list_products ']/li");}

    ElementsCollection priceOfProduct() {return $$x("//p[contains(@class,'actual_price')]");}

    ElementsCollection titleOfProduct() {return $$x("//div[@class='name']/*[self::a or self::span][1]");}
}
