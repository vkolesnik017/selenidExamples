import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Test_PSVM {

    public static void main(String[] args) {
List<Integer> list = Arrays.asList(4,7,4,28);



        // list= map.entrySet().stream().sorted(Map.Entry.<String, String>comparingByKey().reversed()).
        ///   tre.forEach(System.out::println);

/*        String str = "nnnissan xx-trail";
        String[]list = str.split(" ");

        int size = list.length;

        System.out.println(size);
        System.out.println("___________________");
        *//*ПОЛУЧАЕМ СТРОКУ УНИКАЛЬНЫХ ЗНАЧЕНИЙ*//*
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (temp.indexOf(str.charAt(i)) == -1) {
                temp = temp + str.charAt(i);
            }
        }
        *//*РАЗБИВАЕМ УНИКАЛЬНУЮ СТРОКУ НА СИМВОЛЫ*//*
        char[] uniqueArray = temp.toCharArray();
        *//*РАЗБИВАЕМ СТРОКУ, КОТОРАЯ ПРИХОДИТ В КАЧЕСТВЕ ПАРАМЕТРОВ НА СИМВОЛЫ *//*
        char[] symb = str.toCharArray();

        *//*ОБЪЯВЛЯЕМ МАССИВ РАЗМЕРОМ УНИКАЛЬНЫХ СИМОВОЛОВ*//*
        int[][] array = new int[uniqueArray.length][2];
        int count = 0;
        *//* ПРОВЕРЯЕМ СКОЛЬКО РАЗ ВСТЕЧАЮТСЯ УНИКАЛЬНЫЕ СИМВОЛЫ В СТРОКЕ, КОТОРАЯ ПРИХОДИТ В КАЧЕСТВЕ ПАРАМЕТРОВ*//*
        for (int i = 0; i < uniqueArray.length; i++) {
            for (int j = 0; j < symb.length; j++) {
                if (uniqueArray[i] == symb[j]) {
                    ++count;
                }
            }
            *//* ЗАПИСЫВАЕМ СИМВОЛ И СКОЛЬКО РАЗ ОН ВСТРЕЧАЕТСЯ В С ТРОКЕ*//*
            array[i][0] = uniqueArray[i];
            array[i][1] = count;
            count = 0;
        }

        *//*ВЫВОД ДВУМЕРНОГО МАССИВА*//*
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }*/

    }
           /* if(symb[i] == symb[1])
                ++count;
        System.out.println(symb[1]+" - "+count);
        */


    public static void uniqueCharacters(String test) {
        String temp = "";
        for (int i = 0; i < test.length(); i++) {
            if (temp.indexOf(test.charAt(i)) == -1) {
                temp = temp + test.charAt(i);
            }
        }


    }







 /*       List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream().filter(i->i%2==0).collect(Collectors.toList());
        evenNumbers.forEach(System.out::println);

        List<String> names = Arrays.asList("John", "Arya", "Sansa");
        List<String> newName = names.stream().map(String::toUpperCase).collect(Collectors.toList());

        newName.forEach(System.out::println); */

   /*     String s = "https://lkwteile.autodoc.de/ersatzteile/scheibenbremsbelag-200342/iveco/eurostar?car_id=1006726&supplier%5B1%5D=39";
        String minPrice = s.replaceAll("(^.+lier)(\\%.+[A-Z])(.+)","$1$3");


        System.out.println(minPrice);*/
    //   List<Integer> list = Arrays.asList(4, 6, 7, 3, 45, 234, 43);
/*        List<Integer> second = Arrays.asList(345, 345, 676, 234, 5435567, 13245, 4355, 234);
        List<Integer> third = Arrays.asList(2345, 67867, 234, 1234, 543534, 6456456, 234);

        String s = "[Au,,,,to,234324324doc Gm2141324,,,,bH] ";

        String ss = s.replaceAll("(\\[)(.+)(\\])", "$2");*/
    //      System.out.println(ss);

    // Assert.assertTrue(Collections.max(list)<Collections.min(second));

/*        int z, k;

        if (list.get(0) > 3) {
            z = list.get(0);
        } else {
            z = 0;
        }

        k = list.get(0) < 3 ? list.get(0) : 0;

        System.out.println(z + " - " + k);*/

/*        List<String> list = Arrays.asList("5a", "234234er", "df", "er", "a");
        HashSet<String> result = new HashSet<>();
        int minlength = Integer.MAX_VALUE;
        String min = " ";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length()==minlength){
                min = list.get(i);
                minlength = list.get(i).length();
                result.add(list.get(i));
                result.add(min);
            } else


            if (list.get(i).length() < minlength) {
                min = list.get(i);
                minlength = list.get(i).length();
                result.add(list.get(i));
            }
        }
      result.forEach(System.out::println);*/

/*        List<Integer> list = Arrays.asList(4, 6, 3, 1, 4, 56, 7, 8, 5);



        List<Integer> ss = sortedList(list);

        ss.forEach(System.out::println);
        System.out.println("--------------------------------------");
        Integer min = ss.stream().reduce(Integer.MAX_VALUE, Integer::max);
        System.out.println("min- " + min);
        System.out.println("-----------------------------------");

        ss.stream()
                .peek(System.out::println)
                .forEach(n -> doSomeStaff(n));
        System.out.println("----------------------------");

        String john = null;
        Optional<String> name = Optional.ofNullable(john);
        System.out.println(name);*/ //output Optional.empty
/* Collections.sort(list);
        list.forEach(System.out::println);
 List<Integer> s = list.stream().sorted().collect(Collectors.toList());

 s.forEach(System.out::println);*/


    public static List<Integer> sortedList(List<Integer> list) {
        List<Integer> s = list.stream().sorted().collect(Collectors.toList());

        return s;
    }

    private static int doSomeStaff(Integer n) {
        int sum = n * n;
        return sum;
    }


    public Test_PSVM compareTwoListsBetweenSaidbarAndAws(List<Integer> list, List<Integer> list2) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(list2.get(i)) && !list.get(i).equals(list2.get(i + 1)) == false) {
                Assert.assertEquals(list.get(i), list2.get(i - 1));
            }
        }
        if (list.size() != list2.size()) {
            Assert.fail("list size: " + list.size() + " != list2: " + list2.size());
        }
        return this;
    }

}
