/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Naajil Aamir
 */
public class BalancedTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    BTree t=new BTree(3); // A B-Tree with minium degree 3
    t.insert(10);
    t.insert(20);
    t.insert(5);
    t.insert(6);
    t.insert(12);
    t.insert(30);
    t.insert(7);
    t.insert(17);
 
        System.out.println("Traversal of the constucted tree is ");
    t.traverse();
     
   
    }
}
