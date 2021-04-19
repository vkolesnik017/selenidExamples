import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class QC_1508 {
    {
        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
      //  Configuration.holdBrowserOpen = true;
    }

    @Test
    public void test() {
        open("https://www.autodoc.de/autoteile/oem/101000033aa");
       ElementsCollection title = $$x("//span[@class='subname']/ancestor::span");

        System.out.println(title.get(0).getText());
    }
}
