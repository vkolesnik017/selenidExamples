import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class MPC_906 {
    @Test
    public void compareOfId() {
        open("https://taws.autodoc.de/feeds/ebay/templates/1");
        sleep(10000);
        $x("//form[@class='login-form']").shouldBe(visible);
        $(byName("login")).sendKeys("lion");
        $(byName("password")).sendKeys("4e24e740");
        $x("//button[@class='btn btn-default btn-sm pull-right']").submit();
        $x("//table[@class='table table-striped table-responsive table-hover table-bordered table-condensed grid']").shouldBe(visible);
        $x("//div[@id='form_Filter_genericArticleId__chzn']/a").click();
        $x("//ul[@class='chzn-results']//li[2]").click();
        sleep(1000);
        $x("//span[@class='glyphicon glyphicon-plus-sign'][1]").shouldBe(visible).click();
        sleep(1000);
        $x("//div[@class='form-group']").shouldBe(visible);
        sleep(1000);
        System.out.println();
        ElementsCollection id = $$x("//select[@name='alias']/option").filter(exist);
        System.out.println(id.size());
        List<String> idList = new ArrayList<>();

        for (int i = 0; i < id.size(); i++) {
            idList.add(id.get(i).getText());
        }

        for (String e : idList) {
            System.out.println(e);
        }
    }
}
