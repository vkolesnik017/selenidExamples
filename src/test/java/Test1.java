public class Test1 {
    public static void main(String[] args) {
        NumericInterface f= (x,y)->{
            int r=x+y;
            return r;
        };

        NumericInterface umn= (x,y)->{
            int r=x*y;
            return r;
        };

        NumerString ff = (n) -> System.out.println(n);
        ff.ss("hello");

        NumericInterface f1=(x,y) -> x*y;
        System.out.println("Факториал числа 3  = " + f.calculate(5,8));
        System.out.println(umn.calculate(2,9));
        System.out.println(f1.calculate(9,8));
    }

   // public static int func(int n)
}
