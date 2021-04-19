package Json;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DDTTest {

    @BeforeClass
    void setUp() {
        //  Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }

    @AfterClass
    void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    void login() {
     /*   open(JsonReader.new FileReader(".\\Json\\test.json"));
        $(byName("uid")).shouldBe(Condition.visible).setValue("mngr228265");
        $(byName("password")).shouldBe(Condition.visible).setValue("YrUpAra");
        $(byName("btnLogin")).click();*/
    }

    // @DataProvider(name = "dp")
    public String[] readJson() throws IOException, ParseException, FileNotFoundException {

        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        FileReader reader = new FileReader(".\\Json\\test.json");
        Object obj = jsonParser.parse(reader);
        JSONObject userloginsJsonobj = (JSONObject) obj;
        JSONArray userloginsArray = (JSONArray) userloginsJsonobj.get("userlogins");

        String arr[] = new String[userloginsArray.size()];

        for (int i = 0; i < userloginsArray.size(); i++) {
            JSONObject users = (JSONObject) userloginsArray.get(i);
            String user = (String) users.get("username");
            String pwd = (String) users.get("password");

            arr[i] = user + "," + pwd;
        }
        return arr;
    }
}
