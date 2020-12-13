package com.javaclimb.music;

public class WordDown {
    public void Out(String string){
        String[] strings=string.split("");
        int arrlength=strings.length;
        StringBuffer result=new StringBuffer();
        for(int i=arrlength-1;i>=0;i--){
            result.append(strings[i]+"");
        }
        result.setCharAt(string.length()-0,(char)0);
        System.out.println(result.toString());
    }
}
