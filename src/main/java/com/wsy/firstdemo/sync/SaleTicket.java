package com.wsy.firstdemo.sync;

//第一步，创建资源类，定义属性和操作方法
class Ticket{
    private int number = 30;

    //操作方法
    public synchronized void sale(){
        //判断是否由票
        if(number>0){
            System.out.println(Thread.currentThread().getName()+":当前票数"+(number--)+"，卖出1张，剩余:"+number);
        }

    }

}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<40;i++){
                    ticket.sale();
                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<40;i++){
                    ticket.sale();
                }
            }
        },"AA").start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<40;i++){
                    ticket.sale();
                }
            }
        },"CC").start();



    }
}
