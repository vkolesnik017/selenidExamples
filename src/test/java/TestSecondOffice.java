import com.codeborne.selenide.*;
//import org.junit.jupiter.api.Test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestSecondOffice {{
    Configuration.startMaximized=true;

}
@Test
    public void checkTest() {
        open("https://www.autodoc.de/ersatzteile/vw/golf/golf-iv-1j1/8799-1-4-16v");
        $x("//ul[@class='expand list_ersats_row']").shouldBe(visible);

        ElementsCollection image = $$x("//a[@class='ga-click']/img");

    //    int height= image.get(0).getSize().getHeight();
     //   int width = image.get(0).getSize().getWidth();
    verifyimageActive(image.get(0));
  ////      int totalSum = height+width;
//    Assert.assertTrue(totalSum>0,"the picture is broken");

    }

    public void verifyimageActive(SelenideElement imgElement) {
        try {
         int   invalidImageCount = 0;
          HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imgElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            if (response.getStatusLine().getStatusCode() != 200)
                invalidImageCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
