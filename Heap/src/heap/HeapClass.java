/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author User
 */
public class HeapClass {
    
    int size;
    int[] array;
    
    public HeapClass(int sizeOfArray,int[] arr){
        size = sizeOfArray;
        array = arr;
    }
    
    void resize(int[] arr2){
        size++;
        array = new int[size];
        for(int i=0; i<arr2.length; i++){
            array[i] = arr2[i];
        }
    }
    
    int getLeft(int i){
        return 2*i + 1;
    }
    
    int getRight(int i){
        return 2*i + 2;
    }
    
    int getParent(int i){
        return (i-1)/2;
    }
    
    void addElement(int a){
        if(size <= array.length){
            int[] arr2 = array;
            resize(arr2);
        }
        array[size-1] = a;
        upHeap(size-1);
    }
    
    void upHeap(int i){
        int p = getParent(i);
        while(i>0 && array[i] > array[p]){
            int temp = array[i];
            array[i] = array[p];
            array[p] = temp;
            i = p;
            p = getParent(i);
        }
    }
    
    void print(){
        System.out.println("Heap contains: ");
        for(int i=0; i<size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    void downHeapMax(int i){
        int left = getLeft(i);
        int right = getRight(i);
        int max;
        
        while(left < size && right < size){
            if(array[left] > array[right]){
                max = left;
            }
            else{
                max = right;
            }
            
            if(array[i] < array[max]){
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
                i = max;
                left = getLeft(i);
                right = getRight(i);
            }
        }
        
    }
    
    void deleteMax(){
        array[0] = array[size-1];
        size = size - 1;
        downHeapMax(0);
    }
    
    void downHeapMin(int i){
        int left = getLeft(i);
        int right = getRight(i);
        int min;
        
        while(left < size && right < size){
            if(array[left] < array[right]){
                min = left;
            }
            else{
                min = right;
            }
            
            if(array[i] > array[min]){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
                i = min;
                left = getLeft(i);
                right = getRight(i);
            }
        }
        
    }
    
    void deleteMin(){
        array[0] = array[size-1];
        size = size - 1;
        downHeapMin(0);
    }
}
