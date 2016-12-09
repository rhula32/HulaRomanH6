import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MainMethod 
{
  public static void main (String [] args) 
  {
    BinaryTree myTree = new BinaryTree();
    File file = new File("WinterWonderland.rtf");  
    int wordcount = 0;
    try 
    {
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) 
        {
          myTree.insert(sc.next()); 
          wordcount++;// count words in file
        }
        System.out.println("words: " + wordcount);
        myTree.print(4);
        System.out.println(myTree.getSize(myTree.root));
        myTree.balance(myTree.root);
        System.out.println(myTree.deleteNode("c"));
        System.out.println(myTree.deleteNode("a"));
        System.out.println(myTree.deleteNode("l"));
        sc.close();
    } 
    catch (FileNotFoundException e) 
    {
        e.printStackTrace();
    }
    
    myTree.root = new Node("b");
    myTree.root.leftNode = new Node("a");
    myTree.root.rightNode = new Node("d");
    myTree.root.rightNode.leftNode = new Node("c");
    myTree.root.rightNode.rightNode = new Node("e");
  }
}