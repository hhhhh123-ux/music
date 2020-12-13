package com.javaclimb.music;

import com.javaclimb.music.domain.Singer;

public class Test3 {

//    static{
//        System.out.println("1");
//    }
//    {
//        System.out.println("2");
//    }
//
//    public  Test3(){
//        System.err.println("3");
//    }
    public static void main(String[] args) {
//        String aa = "zz";
//        String bb = "ss";
//        String cc=aa+bb;
//        System.out.println(cc);
//        String dd = "zzss";
//        System.out.println(dd);
//        System.out.println(cc==dd);
//        System.out.println(cc.equals(dd));

//        new Test3();
//        Integer a=128;
//        Integer b=128;
//        System.out.println(a==b);
       Singleton s=Singleton.getSingleton();
System.out.println("a="+s.counter1);
        System.out.println("a="+s.countrr2);
    }



}
class Singleton {
    private static Singleton singleton = new Singleton();
   public static int counter1;
    public static int countrr2=0;

    private Singleton() {
        System.out.println(counter1);
        System.out.println(counter1);
   counter1++;
   countrr2++;
    }


    public static Singleton getSingleton() {
        return singleton;
    }
}