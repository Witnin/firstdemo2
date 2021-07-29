package com.wsy.firstdemo.sync;

public class Tess {
    public static void main(String[] args) {
        int[] num={51,15,12,84,21,24,0,114,51,123,1,25,4,6};
        int tmp=0;
        for(int n=0;n<num.length;n++){
            System.out.println(num[n]+"排序前的序号为:"+(n+1));
        }
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]>num[j]){
                    tmp=num[i];
                    num[i]=num[j];
                    num[j]=tmp;
                }
            }
        }
        System.out.println();
        for(int k=0;k<num.length;k++){
            System.out.println(num[k]+"排序后的序号为:"+(k+1));
        }
    }
}
