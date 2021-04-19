import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestForQC {
    @DataProvider(name = "dataValues")
    public Object[][] dataProviderData(){
        return new Object[][]{
                {"https://www.autodoc.de/search?keyword=Bremsscheiben"}
                   };
    }

    @Test (dataProvider = "dataValues")
    public void test(String parameters) {

        open(parameters);
        $x("//ul[@class='list_products']").shouldBe(visible);

        ElementsCollection generics = $$x("//div[@class='filter-generics-tecdoc__list js-filter-generics-tecdoc']//label");

        ElementsCollection prices = $$x("//p[@class='actual_price']");

        int sizeOfGeneric = generics.size();

        switch (sizeOfGeneric) {
            case 1:
            case 2:
            case 3: generics.shouldHaveSize(3);
            break;
            case 4: generics.shouldHaveSize(4);
        }

        List<Double> list = new ArrayList<>();
        List<Double> listS = prices.stream().map(i->{
            return Double.parseDouble(i.getText().replaceAll("[^0-9,]","").replace(",","."));
        }).collect(Collectors.toList());

        for (int i=0; i<prices.size();i++){
            listS.add(Double.parseDouble(prices.get(i).getText().replaceAll("[^0-9,]","").replace(",",".")));
        }

        list.forEach(System.out::println);
        System.out.println("------------------------");

        listS.forEach(System.out::println);
    }
}
