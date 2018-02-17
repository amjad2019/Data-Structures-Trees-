/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;
import java.util.*;
/**
 *
 * @author student
 */
public class Node {

    int size = 14;
    int [] array = new int [size];
    int n;
    int parent =1;

    public Node() {
        parent = 0;
        n = 1;
        size = 10;
    }



    public void insert(int data)
    {
        
            array[n] = data;
             heapSort();
            n++;
            if(n==array.length)
            {
                 int [] newarr=new int[size*5];
                 for(int z=0;z<size;z++)
                 {
                     array[z]=newarr[z];
                 }
                 array=newarr;

            }
            

    }

    public void delete(){
        System.out.println("deleting");
        array[1]=array[n];
        n--;
        maxHeap(n);
 
        
        /*System.out.println("parent" + array[1]);
        array[1] = array[n-1];
        System.out.println("parent" + array[1]);
        n=n-2;
        heapSort();*/
    }
    
    
    public void heapSort(){
        int i = n;
        System.out.println("checking  " + array[i]);
        while(i>0){
            maxHeap(i);
            i = getParent(i);
        }
    }

    public void maxHeap(int n){


        if(array[n]>array[getParent(n)] && getParent(n)>0){
                int temp = array[n];
                array[n] = array[getParent(n)];
                array[getParent(n)] = temp;
            }

    }



    public void print(){
        for(int i =1; i<n; i++){
            System.out.println(array[i]);
        }
    }

    public int getParent(int i){
        return i/2;
    }

    public int getLeft(int i){
        return 2*i ;
    }

    public int getRight(int i){
        return ((2*i) + 1);
    }

}
