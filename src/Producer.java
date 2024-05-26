public class Producer extends Thread{
    //生产者代码
    @Override
    public void run() {
       while (true){
           synchronized (Station.LOCK){
               //判断是否已经生产完了
               if (Station.count == 10){
                   //生产数满了
                   break;
               }else {
                 if (Station.status == 1){
                     //消费数据存在，线程等待
                     try {
                         Station.LOCK.wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 }else {
                     //消费数据不存在，线程执行
                     Station.status = 1;
                     System.out.println("生产者在生产");
                     Station.LOCK.notifyAll();
                 }
               }
           }
       }

    }
}
