
public class bst
{

    
    public static void main(String[] args) 
    {
        Binary_Search_Tree bs=new Binary_Search_Tree();
        bs.insert(5, 25);
        bs.insert(3, 9);
        bs.insert(2, 4);
        bs.insert(4, 16);
        bs.insert(1, 1);
        bs.insert(9, 81);
        bs.insert(10, 100);
        bs.insert(11, 121);
        bs.insert(7, 49);
        bs.insert(8, 64);
        bs.insert(6, 36);
        bs.print();
        System.out.print("\nSearc(8): ");
        if( bs.search(8) )
            System.out.println("Found.");
        else
            System.out.println("Not Found.");
        System.out.print("Searc(55): ");
        
        if( bs.search(55) )
            System.out.println("Found.");
        else
            System.out.println("Not Found.");

        System.out.println("\nDelete(1)");
        bs.delete(1);
        bs.print();
        System.out.println("\nDelete(10)");
        bs.delete(10);
        bs.print();
        System.out.println("\nDelete(7)"); 
        bs.delete(7);
        bs.print();
        System.out.println("\nDelete(9)"); 
        bs.delete(9);
        bs.print();
    
    }


}
