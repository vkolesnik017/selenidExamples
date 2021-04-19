import files.User;
import org.testng.Assert;

import java.util.*;

public class SortingOfUser {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
/*        users.add(new User("Nick", "Boll",12));
        users.add(new User("Jan", "Nicky", 15));
        users.add(new User("Bot", "Smart",14));
        users.add(new User("Bot", "Checking",10));

        users.stream().filter((User p)->"Bot".equals(p.getName())).filter(c->c.getAge()>10).forEach(System.out::println);

        System.out.println("------------------------------------");
        List<User> check = new ArrayList<>(users);

        users.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        users.forEach(System.out::println);
        Assert.assertEquals(users,check);*/



      //  List<String> names = Arrays.asList("John", "Daenerys", "Tyrion", "", null, "Arya");



      /*  names.stream()
                .filter(Objects::nonNull)
                .filter(name -> !name.isEmpty() && name.contains("a"));*/
               // .forEach(System.out::println);
    }
}
