public class ThreadAssignment {

    static class Counter {
        void count() {
            for (int i=350; i>= 1; i--) {
               System.out.println(i);
            }

        }


        static class MyThread extends Thread {
            private final Counter counter;

            public MyThread(Counter counter) {
                this.counter = counter;
            }

            @Override
            public void run() {
                synchronized (counter)
                {
                    counter.count();
                    System.out.println("finish");
                }


            }
        }

        public static void main(String[] args) throws InterruptedException {
            Counter counter = new Counter();
            MyThread c1= new MyThread(counter);
            c1.start();
            MyThread c2=new MyThread(counter);
            c2.start();
            c1.join();
            c2.join();
            System.out.println("DONE!");



        }
    }
}
