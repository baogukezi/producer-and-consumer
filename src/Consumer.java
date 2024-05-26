public class Consumer extends Thread {
    /*
     *消费者的代码
     */
    @Override
    public void run() {
        while (true) {
            synchronized (Station.LOCK){
                //先判断数据是否被消费了
                if (Station.count == 10) {
                    //这里已经被消费完了
                    break;

                } else {
                    if (Station.status == 0) {
                      //0表示没有数据可以消费,等待
                        try {
                            Station.LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        //可以进行消费
                        Station.count++;
                        Station.status = 0;
                        System.out.println("消费者正在消费数据,消费了第"+Station.count+"条数据");
                        Station.LOCK.notifyAll();
                    }
                }
            }


        }
    }
}
