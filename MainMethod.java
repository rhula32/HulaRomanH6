import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MainMethod 
{
  public static void main(String[] args) 
  {
    BinaryTree myTree = new BinaryTree();
    File file = new File("JingleBells.rtf");  
    int wordcount = 1;
    int indWordCount = 1;
    try 
    {
      Scanner song = new Scanner(file);
      System.out.println("Printing the word frequency histogram: ");
      while(song.hasNext())
      {
        myTree.printHistogram(song.next(), indWordCount);
        wordcount++;
      }
      System.out.println("Total Wordcount = " + (wordcount - 1));
    } 
    catch(FileNotFoundException e) 
    {
      e.printStackTrace();
    }
  }
}