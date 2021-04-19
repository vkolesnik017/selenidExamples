import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MPC_907 {
    {
        Configuration.holdBrowserOpen=true;
        Configuration.timeout=6000;
        Configuration.startMaximized=true;
    }
    CheckProduct page = new CheckProduct();

    @Test
    public void checkProducts() throws IOException {
        List<Integer> idOfProducts = page.getProductFromFile();
        page.loginInAWS();
        page.openProductPage(idOfProducts);
    }
}
