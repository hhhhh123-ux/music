package com.javaclimb.music;

public class Test {
    public static  void main(String[]  args){


        int j=0;

        for (int i=100;i<1000;++i){
            int b=i/100;
            int c=i/10%10;
            int d=i%10;
            if(b!=c&&b!=d&&c!=d){
                if((b==1||b==2||b==3||b==4)&&(c==1||c==2||c==3||c==4)&&(d==1||d==2||d==3||d==4)){
                    System.out.println(i);
                    j=j+1;
                }
            }

        }

System.out.println(j);
    }

}
