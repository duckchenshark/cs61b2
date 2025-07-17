package org.example;

public class Main {
    private int[] parents;

    public void UnionFind(int n){
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=-1;
        }
    }

    public void validate(int v1){
        if(v1<0||v1>parents.length){
            return 
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}