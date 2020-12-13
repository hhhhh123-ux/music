package com.javaclimb.music;

public class Test1 {
    public static  void main(String[]  args){
        String string="how are you hehe";

        String[] strings=string.split(" ");
        StringBuffer result=new StringBuffer();
        int arrlength=strings.length;
        for(int i=arrlength-1;i>=0;i--){

            result.append(" "+strings[i]);

        }
        System.out.println(result);

//
//            for (int i=0;i<arrlength/2;i++){
//                   s=strings[i];
//                   strings[i]=strings[arrlength-1-i];
//                   strings[arrlength-1-i]=s;
//            }
//            for(int x=0;x<arrlength;x++){
//                System.out.println(strings[x]);
//            }

    }
}
