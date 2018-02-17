/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

/**
 *
 * @author student
 */
public class Heap {

    public static void main(String[] args){
        Node a = new Node();

        a.insert(4);
        a.insert(1);
        a.insert(3);
        a.insert(2);
        a.insert(16);
        a.insert(9);
        a.insert(31);
        a.insert(22);
        a.insert(116);
        a.insert(95);
        a.delete();
        a.print();
        
        System.out.println("");
        
    }

}
