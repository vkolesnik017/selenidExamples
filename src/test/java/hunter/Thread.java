package hunter;

import static java.lang.Thread.sleep;

public class Thread {

 static boolean win = false;
    public static void main(String[] args) {

        java.lang.Thread timer = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        if (i==5) {
                            win=true;
                        }
                        System.out.println(i);
                        sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        java.lang.Thread timerS = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   if(win==true) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("Second thread");
                        sleep(1000);
                    } }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });timer.start();
        timerS.start();
    }
}
