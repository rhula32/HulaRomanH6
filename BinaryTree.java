import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinaryTree
{
  Node root;
  
  BinaryTree()
  {
    this.root = null;
  }
  
  public boolean isEmpty() 
  {
    return this.root == null;
  }
  
  public void insertNode(String newWord)
  {
    Node newNode = new Node(newWord);
    if(this.isEmpty())
    {
      this.root = newNode;
    }
    else
    {
      Node current = this.root;
      while(current != null)
      {
        if(newWord.compareTo(current.word) >  0) 
        {
          if(current.right == null) 
          {
            current.right = newNode;
          }
          current = current.right;
        }
        else if(newWord.compareTo(current.word) < 0) 
        {
          if (current.left == null) 
          {
            current.left = newNode;
          }
          current = current.left;
        }
        else
        {
          current.count++;
        }
      }
    }
  }
  
  
  
  public static void main(String[] args) 
  {
  }
}

class Node 
{
  public String word;
  public int count;
  public Node parentNode;
  public Node left;
  public Node right;
  
  Node(String word) 
  { 
    this.word = word; 
    this.count = 1;
    this.parentNode = null;
    this.left = null;
    this.right = null;
  }
  
  public void printWord() 
  {
    System.out.print(word + " " );
  }
}