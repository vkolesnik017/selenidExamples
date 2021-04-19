package eBay;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class MPC776 {
    {
        Configuration.holdBrowserOpen = true;
        // Configuration.startMaximized = true;
        Configuration.timeout = 6000;
    }

    @Test
    public void check() {

        try {
            FileInputStream fis = new FileInputStream("test.xls");
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            List<Integer> myMap = new ArrayList<>();
          /* for (Row row : wb.getSheetAt(10)) {
               myMap.add((int)row.getCell(0).getNumericCellValue());
           }*/

            for (int i = 12; i <= 14; i++) {
                for (Row row : wb.getSheetAt(i)) {
                    myMap.add((int) row.getCell(0).getNumericCellValue());
                }
            }
            System.out.println("myMap - " + myMap.size());
            String brand = "HART";
            open("https://aws.autodoc.de/products/search");
            $(byXpath("//input[@id='login']")).shouldBe(visible);
            $(byXpath("//input[@id='login']")).setValue("lion");
            $(byXpath("//input[@id='password']")).setValue("4e24e740");
            $(byXpath("//button[@class='btn btn-default btn-sm pull-right']")).click();
            $(byId("order_products_list")).shouldBe(visible);
            $(byId("form_filterSearch[onStorage]")).selectOptionByValue("no");

            $(byXpath("//div[@id='form_filterSearch_suppliers__chzn']//input")).shouldBe(visible).setValue(brand);
            $(byXpath("//em[contains(text(),'" + brand.toUpperCase() + "')]")).shouldBe(visible).click();
            $(byId("form_filterSearch[inSuplierStocks]")).selectOptionByValue("yes");
            //  $(byName("filterSearch[hasTecdocId]")).selectOptionByValue("yes");
            $(byId("form_submit")).submit();
            $(byXpath("//table[@id='order_products_list']//tr[2]//td[5]")).shouldHave(text(brand));

            String lastPage = $(byXpath("//div[@id='contentwrapper']//li[9]//a")).getAttribute("href");
            String currentUrl = url();

            List<Integer> id = new ArrayList<>();

            ElementsCollection idFromTable = $$(byXpath("//table[@id='order_products_list']//tr//td[1]"));
            SelenideElement paginator = $(byXpath("//ul[@class='pagination']/li[8]/a"));
            int lasTPage = Integer.parseInt($(byXpath("//div[@id='contentwrapper']//li[9]//a")).getAttribute("href").substring(44));
            if (paginator.isDisplayed()) {
                for (int i = 0; i <35; i++) {
                    for (int j = 0; j < idFromTable.size(); j++) {
                        id.add(Integer.parseInt(idFromTable.get(j).getText()));
                    }
                    paginator.click();
                }
            } else {
                for (int j = 0; j < idFromTable.size(); j++) {
                    id.add(Integer.parseInt(idFromTable.get(j).getText()));
                }
            }
            if (url().equals(lastPage)) {
                for (int i = 0; i < idFromTable.size(); i++) {
                    id.add(Integer.parseInt(idFromTable.get(i).getText()));
                }
            }
//            System.out.println("myMap - " + myMap.size());
//           System.out.println("id - " + id.size());


           /* for (int i = 0; i < id.size(); i++) {
                System.out.println(id.get(i));
            }*/
            System.out.println("------------------------------------------");


            boolean found = false;

            for (int i = 0; i < myMap.size(); i++) {
                for (int j = 0; j < id.size(); j++) {
                    if (myMap.get(i).equals(id.get(j))) {
                        found = true;
                        System.out.println(id.get(j));
                        break;
                    }
                }
            }
            if (found == false) {
                System.out.println("Совпадений не найдено!!!");
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void checkSKU() {

    }
}
