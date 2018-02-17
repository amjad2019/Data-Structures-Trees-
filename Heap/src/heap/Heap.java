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
public class Heap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = new int[]{70,50,12,16};
        int sizeOfArray = array.length;
        HeapClass obj = new HeapClass(sizeOfArray, array);
        
        
        
        
        obj.print();
        
        obj.addElement(55);
        System.out.println("After insertion of 55");
        obj.print();
        
        int[] array2 = new int[]{100,80,70,55,57,45,35,50,48,4,15,4,15,20,25,49};
        int sizeOfArray2 = array2.length;
        HeapClass obj2 = new HeapClass(sizeOfArray2, array2);
        
        obj2.print();
        obj2.addElement(95);
        System.out.println("After inserion of 95");
        obj2.print();
        
        int[] array3 = new int[]{100,50,70,40,30,55,45,38,27,4,15,15,4};
        int sizeOfArray3 = array3.length;
        HeapClass obj3 = new HeapClass(sizeOfArray3, array3);
        
        obj3.deleteMax();
        obj3.print();
        
        int[] array4 = new int[]{-10,0,10,10,5,15,20,12,20,13,7,20,25,30};
        int sizeOfArray4 = array4.length;
        HeapClass obj4 = new HeapClass(sizeOfArray4, array4);
        
        obj4.deleteMin();
        obj4.print();
        
    }
    
}
