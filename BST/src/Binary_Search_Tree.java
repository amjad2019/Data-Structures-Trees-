
public class Binary_Search_Tree
{
    Node root;
    Binary_Search_Tree()
    {
    root=null;
    }

    boolean insert(int k,int d)
    {
        Node u=this.findlast(k);
        Node add=new Node(k,d);
        if (u == null )
            root=add;
        else if(u.key == k)
        {
        u.data=d;
        }
        else
           if( u.key > k)
           {
            u.left=add;
            add.parent=u;
           }
           else
           {
            u.right=add;
            add.parent=u;
           }
            return true;
    }

    Node findlast(int k)
    {

        Node temp=root,prev=null;
        int cmp=0;

        while( temp != null )
        {
            if( temp.key > k )
            {
                prev=temp;
                temp=temp.left;
            }
            else if (temp.key < k)
            {
                prev=temp;
                temp=temp.right;
            }
              else
                return temp;
        }
        return prev;
    }
    
    boolean search(int k)
    {
        Node u=this.findlast(k);
        if( u.key == k )
            return true;
        else
            return false;
    }
    
    void print()
    {
    this.traverse(root);
    }
    
    void traverse(Node r)
    {
    if( r == null )
        return;
        System.out.println("Key: "+r.key+" Data: "+r.data);
        traverse(r.left);
        traverse(r.right);
    }

    void Transplant(Node u,Node v)
    {
        
 	if (u.parent == null)
 		root = v;
        else if (u == u.parent.left)
        {
            u.parent.left = v;
            
        }
        else 
        {
            u.parent.right = v;
            
        }
 	if (v != null)
 		v.parent = u.parent;
    }
    
    void delete(int k)
    {
        if ( this.search(k) )
        {
            Node u=this.findlast(k);
            this.DeleteNode(u);
        }
        
    }
    boolean DeleteNode(Node u)
    {
        
        if (u.left == null)
		Transplant(u, u.right);
        else if ( u.right == null )
		Transplant(u, u.left);
 	else 
        {
            Node temp = this.Minimum(u.right);
 		if ( temp.parent != u )
                {	Transplant(temp, temp.right);
 			temp.right = u.right;
 			temp.right.parent = temp;
                }
                Transplant(u, temp);
 		       
                temp.left = u.left;
 		temp.left.parent = temp;
        }
    return true;
    }
    
    Node Minimum(Node u)
    {
        while(u.left != null )
        u=u.left;
        return u;
    }
}
