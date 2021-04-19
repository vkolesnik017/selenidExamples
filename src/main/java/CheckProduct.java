import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class CheckProduct {
    List<Integer> myMap = new ArrayList<>();
    public List<Integer> getProductFromFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream("test.xls");
            HSSFWorkbook wb = new HSSFWorkbook(fis);

           for (Row row : wb.getSheetAt(15)) {
               myMap.add((int)row.getCell(0).getNumericCellValue());
           }

           /* for (int i = 6; i <= 14; i++) {
                for (Row row : wb.getSheetAt(i)) {
                    myMap.add((int) row.getCell(0).getNumericCellValue());
                }
            }*/
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myMap;
    }

    public void loginInAWS(){
        open("https://aws.pkwteile.de/products/view/1235");
        $(byName("login")).setValue("lion");
        $(byId("password")).setValue("4e24e740");
        $x("//*[@class='btn btn-default btn-sm pull-right']").click();
        $x("//div[@class='row']").shouldBe(visible);
    }

    public void openProductPage(List<Integer> list) {
        for (int i = 0; i < 700; i++) {
            open("https://aws.pkwteile.de/products/view/" + list.get(i));
            int mainStok = Integer.parseInt($x("//td[contains(text(),'Основной склад')]/following-sibling::td[1]/span").getText());
            int stockC = Integer.parseInt($x("//td[contains(text(),'Склад С')]/following-sibling::td[1]/span").getText());
            int stockPL = Integer.parseInt($x("(//td[contains(text(),'Склад PL')]/following-sibling::td[1]/span)[1]").getText());
            int stockPLC = Integer.parseInt($x("(//td[contains(text(),'Склад PL')]/following-sibling::td[1]/span)[2]").getText());
            int stockE = Integer.parseInt($x("//td[contains(text(),'Склад E')]/following-sibling::td[1]/span").getText());
            int stockR = Integer.parseInt($x("//td[contains(text(),'Склад R')]/following-sibling::td[1]/span").getText());
            int sumOfAllStocks = mainStok + stockC + stockPL + stockPLC + stockE+stockR;

            double priceOfProduct = Double.parseDouble($x("//td[contains(text(),'Цена')]/following-sibling::td/span").getText());
         //   System.out.println(list.get(i) + " - " + sumOfAllStocks);
            if (sumOfAllStocks >0) {
                System.out.println(list.get(i));
            }
        }
    }
}
