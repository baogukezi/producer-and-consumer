public class Station {
    /*
    此类作用是生产者和消费者之间的中转站
    */

    //是否有数据可以消费 1表示有 0表示没有
    public static int status = 0;

    //线程总的数量
    public static int count = 0;

    //锁对象
    public static final Object LOCK = new Object();
}
