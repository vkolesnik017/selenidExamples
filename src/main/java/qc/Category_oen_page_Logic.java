package qc;

import com.codeborne.selenide.Condition;

import java.util.ArrayList;
import java.util.List;

public class Category_oen_page_Logic extends Category_oen_page {

    public Category_oen_page_Logic checkOemListing() {
        String fin = null;
        String motor = null;
        String sss = null;
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < listProducts().size(); i++) {
            if (titleOfProduct().get(i).has(Condition.attribute("url"))) {
                sss = titleOfProduct().get(i).getAttribute("url");
            } else {
                sss = titleOfProduct().get(i).getAttribute("href");
            }
            motor = sss.replace(sss.substring(sss.lastIndexOf("/")), "");
            String ss = motor.replace(motor.substring(motor.lastIndexOf("/")), "");
            String s1 = sss.replaceAll(ss, "").replaceAll("[^a-z-]", "");

            if (s1.contains("-")) {
                fin = s1.replaceAll("-", " ").toUpperCase();
            } else {
                fin = s1.toUpperCase();
            }
            String cutOen = titleOfProduct().get(i).getText().replaceAll(fin + " ", " ");
            String cutOen2 =  cutOen.replace(cutOen.substring(cutOen.lastIndexOf("OE")), "");

            Product productPage = new Product();
            productPage.setBrand(fin);
            productPage.setGeneric(cutOen2);
            productPage.setPrice(priceOfProduct().get(i).getText());
            productList.add(productPage);
            System.out.println(productList.get(i).getBrand() + " - " + productList.get(i).getGeneric() + " - " + productList.get(i).getPrice());
        }
        return this;
    }
}
