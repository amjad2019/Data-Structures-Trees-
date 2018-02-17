/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblacktree;

/**
 *
 * @author Naajil Aamir
 */
public class RedBlackTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    rbtree a = new rbtree();
    a.insert(5);
    a.insert(3);
    a.insert(7);
    a.insert(2);
    a.insert(4);
    a.insert(6);
    a.insert(8);
    a.insert(11);
    //printf("inorder Traversal Is : ");
        System.out.println("Inorder:");
    a.inordercall();
 
    
    }
    
}
