import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class Test1 {
    public static void main(String[] args) {

        ElementsCollection list = $$x("//div");

 /*       List<Integer> list = Arrays.asList(4, 8, 5, 2, 1,8,4,1,5, 3, 5, 89);
        List<Integer> hashList = list.stream().distinct().sorted().collect(Collectors.toList());

        long count = list.stream().count();

        System.out.println(count);
        hashList.forEach(System.out::println);*/

        Assert.assertEquals(2.23f,2.29f,0.03);

        List<String> allTitles = list.stream().map(n->n.getText()).collect(Collectors.toList());

    }



}
