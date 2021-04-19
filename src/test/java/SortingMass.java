import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import  static com.codeborne.selenide.Selectors.*;
import static  com.codeborne.selenide.Selenide.*;
import  static com.codeborne.selenide.Condition.*;
//import  static com.codeborne.selenide.CollectionCondition.*;

public class SortingMass {

@Test
    public void checkTest() {

        open("https://vertex-academy.com/tutorials/ru/samouchitel-po-java-s-nulya/");

//        element(byXpath("//li[@id='menu-item-1578']//a[contains(text(),'Java')]")).click();

    ElementsCollection arr = elements(byXpath("//div[@class='menu-tutorial-menu-java-ru-container']//li"));

//    List<String> checkList = new ArrayList<>();
//
//    for (SelenideElement el: arr) {
//        String checkTitle = el.getText();
//        checkList.add(checkTitle);
//    }
//    System.out.println(checkList.get(5));



    boolean found = false;
    for (int i=0; i<arr.size(); i++) {
        if (arr.get(i).has(text("Урок 1: История создания Java"))) {
            arr.get(i).click();
            found=true;


            break;
        }
    }
    if (found==false) {
        System.out.println("значение не найдено");
    }
    element(byXpath("//h1[@class='entry-title']")).shouldHave(text("Урок 1: История создания Java"));
    System.out.println((element(byXpath("//h1[@class='entry-title']")).getText()));
    }
}
