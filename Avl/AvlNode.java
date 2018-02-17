
package avl;

    public class AvlNode {
        
private int value;
private AvlNode left;
private AvlNode right;
private int height;

public AvlNode(int value)
{
this.value = value;
left = null;
right = null;
height = 0;
}

    AvlNode() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


public int getValue()
{ 
    return value;
}

public void setValue(int value)
{
    this.value = value;
}

public AvlNode getLeft()
{ 
    return left;
}

public void setLeft(AvlNode left)
{
    this.left = left;
}

public AvlNode getRight()
{ 
    return right;
}

public void setRight(AvlNode right)
{ 
    this.right = right;
}

public int getHeight() {
return height;
}

public void setHeight(int height)
{ 
    this.height = height;
}

 public void makeEmpty( )
        {
            value = 0;
        }

 /*private AvlNode find( int x, AvlNode t )
        {
            while( t != null )
                if( x.compareTo( t.element ) < 0 )
                    t = t.left;
                else if( x.compareTo( t.element ) > 0 )
                    t = t.right;
                else
                    return t;    // Match

            return null;   // No match
        }
*/


         // Return maximum of lhs and rhs.
        
        private static int max( int lhs, int rhs )
        {
            return lhs > rhs ? lhs : rhs;
        }

//find lowest value
 private AvlNode findMin( AvlNode t )
        {
            if( t == null )
                return t;

            while( t.left != null )
                t = t.left;
            return t;
        }
 
        //find heighest value
         private AvlNode findMax( AvlNode t )
        {
            if( t == null )
                return t;

            while( t.right != null )
                t = t.right;
            return t;
        }
         
         //Height of node:
          private static int height( AvlNode t )
        {
            return t == null ? -1 : t.height;
        }
          
          //Rotate with left child:
          private static AvlNode rotateWithLeftChild( AvlNode k2 )
        {
            AvlNode k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;
            k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
            k1.height = max( height( k1.left ), k2.height ) + 1;
            return k1;
        }
        
          //Rotate with right child:
           private static AvlNode rotateWithRightChild( AvlNode k1 )
        {
            AvlNode k2 = k1.right;
            k1.right = k2.left;
            k2.left = k1;
            k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
            k2.height = max( height( k2.right ), k1.height ) + 1;
            return k2;
        }
 
           
         /**
         * Double rotate binary tree node: first left child
         * with its right child; then node k3 with new left child.
         * For AVL trees, this is a double rotation for case 2.
         * Update heights, then return new root.
         */
        private static AvlNode doubleWithLeftChild( AvlNode k3 )
        {
            k3.left = rotateWithRightChild( k3.left );
            return rotateWithLeftChild( k3 );
        }
        
        /**
         * Double rotate binary tree node: first right child
         * with its left child; then node k1 with new right child.
         * For AVL trees, this is a double rotation for case 3.
         * Update heights, then return new root.
         */
        private static AvlNode doubleWithRightChild( AvlNode k1 )
        {
            k1.right = rotateWithLeftChild( k1.right );
            return rotateWithRightChild( k1 );
        }
        
        
        
}