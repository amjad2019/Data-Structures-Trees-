/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Naajil Aamir
 */
public class BTree {

    BTreeNode root; // Pointer to root node
    int t;  // Minimum degree

    // Constructor (Initializes tree as empty)
    BTree(int _t)
    {  root = null;  t = _t; }
 
    // function to traverse the tree
    void traverse()
    {  if (root != null) root.traverse(); }
 
    // function to search a key in this tree
    BTreeNode search(int k)
    {  
        if(root==null){
            return null;
        }
        else 
           return root.search(k);
    }

public void insert(int k)
{
    // If tree is empty
    if (root == null)
    {
        // Allocate memory for root
        root = new BTreeNode(t, true);
        root.keys[0] = k;  // Insert key
        root.n = 1;  // Update number of keys in root
    }
    else // If tree is not empty
    {
        // If root is full, then tree grows in height
        if (root.n == 2*t-1)
        {
            // Allocate memory for new root
            BTreeNode s = new BTreeNode(t, false);
 
            // Make old root as child of new root
            s.C[0] = root;
 
            // Split the old root and move 1 key to the new root
            s.splitChild(0, root);
 
            // New root has two children now.  Decide which of the
            // two children is going to have new key
            int i = 0;
            if (s.keys[0] < k)
                i++;
            s.C[i].insertNonFull(k);
 
            // Change root
            root = s;
        }
        else  // If root is not full, call insertNonFull for root
            root.insertNonFull(k);
    }
}
} 
