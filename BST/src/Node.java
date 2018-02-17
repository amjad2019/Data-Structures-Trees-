
public class Node
{
    int key;
    int data;
    Node left;
    Node right;
    Node parent;

    Node()
    {
    left=right=parent=null;
    key=data=0;
    }
    Node(int k, int d)
    {
    left=right=parent=null;
    key=k;
    data=d;
    }

}
