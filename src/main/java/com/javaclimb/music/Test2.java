package com.javaclimb.music;

public class Test2 {
    public static void converse(String s) {
        String[] ss = s.split(" ");
        String temp = "";
        int bb = ss.length;
        for (int i = 0; i < bb/2; i++) {
            temp = ss[i];
            ss[i] = ss[bb-1-i];
            ss[bb-1-i] = temp;
        }
        for(int x=0;x<bb;x++){
            System.out.println(ss[x]);
        }
    }

    public static void main(String[] args) {
        String str = "how are you hehe";
        Test2.converse(str);

    }

}
