import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class Test2 {
    {
        Configuration.holdBrowserOpen=true;
    }
@Test
  public void test(){
      open("https://mail.google.com/");
      $(byXpath("//div[@class='xkfVF']")).shouldBe(visible);
      $(byName("identifier")).setValue("simple19986@gmail.com").pressEnter();
    //  $(byXpath("//span[@class='CwaK9']")).click();
      $(byXpath("//h1[@id='headingText']")).shouldBe(visible);
      $(byName("password")).setValue("lion1986").pressEnter();
   //   $(byXpath("//span[contains(text(),'Далее')]")).click();
  }
}
