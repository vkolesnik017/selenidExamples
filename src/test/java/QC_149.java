import com.codeborne.selenide.*;
import files.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;

public class QC_149 {
    {
        Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }

    @Test
    public void test() {

        open("https://www.autodoc.de/autoteile");

        $x("//div[@class='list_ersats_n list-ersatz-n--catalog']").shouldBe(visible);

        ElementsCollection titleOfCAtegories = $$x("//span[@class='name']");
     //   List<User> parentCategoriesFromCatalog = new ArrayList<>();
        List<String> parentCategoriesFromCatalog = titleOfCAtegories.stream()
                .filter(title -> !title.getText().equals("Reifen"))
                .map(title -> title.getText().replaceAll(" ",""))
                .collect(Collectors.toList());

      /*  for (int i=0;i<titleOfCAtegories.size();i++) {
            if (i==0){
                continue;
            }
            User user = new User();
            user.setParentCategory(titleOfCAtegories.get(i).getText());
            parentCategoriesFromCatalog.add(user);
        }*/

/*
for (int i=0;i<parentCategoriesFromCatalog.size();i++) {
    System.out.println(parentCategoriesFromCatalog.get(i).getParentCategory());
}*/
       parentCategoriesFromCatalog.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        open("https://aws.pkwteile.de/custom-catalog?filter%5Blang%5D=de&filter%5Bskin%5D%5B%5D=atd&filter%5Borigin%5D=&filter%5BnodeParentID%5D=&filter%5BnodeID%5D=&filter%5Bga%5D=&filter%5Bonly%5D=1&filter%5BorderBy%5D=groupRating&submitSearch=");

       $(byId("login")).shouldBe(visible).setValue("lion");
        $(byId("password")).shouldBe(visible).setValue("4e24e740");
        $x("//button[@class='btn btn-default btn-sm pull-right']").click();
        $x("//div[@class='main-container-list']").shouldBe(visible);
        ElementsCollection parentCategoriesFromAws = $$x("//div[@class='size-300 flex-box']/input");

        List<String> categoriesFromAws = parentCategoriesFromAws.stream().map(n->n.getAttribute("data-old-value").replaceAll(" ","")).collect(Collectors.toList());



        categoriesFromAws.forEach(System.out::println);


        int previousIndex = 0;
/*        for (String uiProduct : parentCategoriesFromCatalog) {
            int currentIndex = categoriesFromAws.lastIndexOf(uiProduct);
            Assert.assertTrue(currentIndex > -1, String.format("There is no %s product in database", uiProduct));
            Assert.assertTrue(currentIndex >= previousIndex,
                    String.format("%1$s product should be after %2$s product but was not", uiProduct, categoriesFromAws.get(previousIndex)));
            previousIndex = currentIndex;
        }*/


        for (int i=0; i<parentCategoriesFromCatalog.size();i++){
            int currentIndex = categoriesFromAws.lastIndexOf(parentCategoriesFromCatalog.get(i));
            Assert.assertTrue(currentIndex > -1, String.format("There is no %s product in database", parentCategoriesFromCatalog.get(i)));
            Assert.assertTrue(currentIndex >= previousIndex,
                    String.format("%1$s product should be after %2$s product but was not", parentCategoriesFromCatalog.get(i), categoriesFromAws.get(previousIndex)));
            previousIndex = currentIndex;
        }





 /*       List<User> listBeforeSorting = new ArrayList<>(parentCategoriesFromCatalog);
        Comparator<String> genericsComparator = (g1, g2) -> {
            if (!categoriesFromAws.contains(g1)) {
                return 1;
            }
            if (!categoriesFromAws.contains(g2)) {
                return -1;
            }
            return categoriesFromAws.indexOf(g1) - categoriesFromAws.indexOf(g2);
        };
        System.out.println("----------------------------99999999--------------------------------");

        Comparator<User> productsComparator = Comparator.comparing(User::getParentCategory,genericsComparator);
        parentCategoriesFromCatalog.sort(productsComparator);

        for (int i=0;i<parentCategoriesFromCatalog.size();i++) {
            System.out.println(parentCategoriesFromCatalog.get(i).getParentCategory());
        }
        Assert.assertEquals(parentCategoriesFromCatalog,listBeforeSorting);*/
    }

}
