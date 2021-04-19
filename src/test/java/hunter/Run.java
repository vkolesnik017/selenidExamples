package hunter;

import static java.lang.Thread.sleep;

public class Run implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                System.out.println(i);
                sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
