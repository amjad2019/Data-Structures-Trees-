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
public class rbtree {
    public Node root;
    public void LeftRotate(Node x){
        //y stored pointer of right child of x
        Node y = x.right;
        //store y's left subtree's pointer as x's right child
        x.right = y.left;

        //update parent pointer of x's right
        if (x.right != null)
            x.right.parent = x;

        //update y's parent pointer
        y.parent = x.parent;

        // if x's parent is null make y as root of tree
        if (x.parent == null)
           root = y;

        // store y at the place of x
        else if (x == x.parent.left)
            x.parent.left = y;
        else    x.parent.right = y;

        // make x as left child of y
        y.left = x;

        //update parent pointer of x
        x.parent = y;   
    }
    public void rightRotate(Node y){
        Node x = y.left;
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;
        x.parent =y.parent;
        if (x.parent == null)
            (root) = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else y.parent.right = x;
        x.right = y;
        y.parent = x;
} 
    public void insertFixUp(Node z)
    {
        // iterate until z is not the root and z's parent color is red
        while (z != root && z.parent.color == 'R')
        {
            Node y;

            // Find uncle and store uncle in y
            if (z.parent == z.parent.parent.left)
                y = z.parent.parent.right;
            else
                y = z.parent.parent.left;

            // If uncle is RED, do following
            // (i)  Change color of parent and uncle as BLACK
            // (ii) Change color of grandparent as RED
            // (iii) Move z to grandparent
            if (y.color == 'R')
            {
                y.color = 'B';
                z.parent.color = 'B';
                z.parent.parent.color = 'R';
                z = z.parent.parent;
            }

            // Uncle is BLACK, there are four cases (LL, LR, RL and RR)
            else
            {
                // Left-Left (LL) case, do following
                // (i)  Swap color of parent and grandparent
                // (ii) Right Rotate Grandparent
                if (z.parent == z.parent.parent.left &&
                    z == z.parent.left)
                {
                    char ch = z.parent.color ;
                    z.parent.color = z.parent.parent.color;
                    z.parent.parent.color = ch;
                    rightRotate(z.parent.parent);
                }

                // Left-Right (LR) case, do following
                // (i)  Swap color of current node  and grandparent
                // (ii) Left Rotate Parent
                // (iii) Right Rotate Grand Parent
                if (z.parent == z.parent.parent.left &&
                    z == z.parent.right)
                {
                    char ch = z.color ;
                    z.color = z.parent.parent.color;
                    z.parent.parent.color = ch;
                    LeftRotate(z.parent);
                    rightRotate(z.parent.parent);
                }

                // Right-Right (RR) case, do following
                // (i)  Swap color of parent and grandparent
                // (ii) Left Rotate Grandparent
                if (z.parent == z.parent.parent.right &&
                    z == z.parent.right)
                {
                    char ch = z.parent.color ;
                    z.parent.color = z.parent.parent.color;
                    z.parent.parent.color = ch;
                    LeftRotate(z.parent.parent);
                }

                // Right-Left (RL) case, do following
                // (i)  Swap color of current node  and grandparent
                // (ii) Right Rotate Parent
                // (iii) Left Rotate Grand Parent
                if (z.parent == z.parent.parent.right &&
                    z == z.parent.left)
                {
                    char ch = z.color ;
                    z.color = z.parent.parent.color;
                    z.parent.parent.color = ch;
                    rightRotate(z.parent);
                    LeftRotate(z.parent.parent);
                }
            }
        }
        (root).color = 'B'; //keep root always black
    }
    
public void insert(int data)
    {
        // Allocate memory for new node
        Node z = new Node();
        z.data = data;
        z.left = z.right = z.parent = null;

         //if root is null make z as root
        if (root == null)
        {
            z.color = 'B';
            (root) = z;
        }
        else
        {
            Node y = null;
            Node x = (root);

            // Follow standard BST insert steps to first insert the node
            while (x != null)
            {
                y = x;
                if (z.data < x.data)
                    x = x.left;
                else
                    x = x.right;
            }
            z.parent = y;
            if (z.data > y.data)
                y.right = z;
            else
                y.left = z;
            z.color = 'R';

            // call insertFixUp to fix reb-black tree's property if it
            // is voilated due to insertion.
            insertFixUp(z);
        }
    } 
public void inordercall(){
        inorder(root);
    }
public void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
