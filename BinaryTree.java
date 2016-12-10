public class BinaryTree 
{
  Node root;
  Node subTree;
  
  BinaryTree() 
  { 
    this.root = null;
  }
  
  public boolean isEmpty() 
  {
    return this.root == null;
  }
  
  public boolean searchForWord(String search, Node subTree)
  {
    if(subTree == null)
    {
      return false;
    }
    if(search.compareTo(subTree.word) == 0)
    {
      return true;
    }
    if(search.compareTo(subTree.word) < 0)
    {
      return searchForWord(search, subTree.leftNode);
    }
    else
    {
      return searchForWord(search, subTree.rightNode);
    }
  }
  
  public void insertNode(String newWord) 
  {
    Node newNode = new Node(newWord);
    this.insertWord(this.root, newNode); 
  }
  
  public void insertWord(Node subTree, Node newNode) 
  {
    if(newNode == null) 
    {
    }
    else if(this.root == null) 
    {
      this.root = newNode;
    }
    else if(newNode.word.compareTo(subTree.word) == 0) 
    {
      subTree.count++; 
    }
    else if(newNode.word.compareTo(subTree.word) < 0) 
    {
      if(subTree.leftNode == null) 
      {
        subTree.leftNode = newNode;
        newNode.parentNode = subTree;
      }
      else 
      {
        this.insertWord(subTree.leftNode, newNode);
      }
    }
    else 
    {
      if(subTree.rightNode == null) 
      {
        subTree.rightNode = newNode;
        newNode.parentNode = subTree;
      }
      else 
      {
        this.insertWord(subTree.rightNode, newNode);
      }
    }
  }
  
  public boolean deleteNode(String word) 
  {
    return(this.deleteWord(this.root, word));
  }
  
  public boolean deleteWord(Node subTree, String word) 
  {
    if(this.root == null) 
    {
      return(false);
    }
    else if(word.compareTo(subTree.word) == 0) 
    {
      this.insertWord(subTree.leftNode, subTree.rightNode);
      if(subTree == this.root) 
      {
        this.root = subTree.leftNode;
        this.root.parentNode = null;
      }
      else if(subTree.leftNode != null) 
      {
        subTree.leftNode.parentNode = subTree.parentNode;
        subTree.parentNode.leftNode = subTree.leftNode;
      } 
      else if(subTree.parentNode.leftNode != null && subTree.parentNode.leftNode.word.compareTo(word) == 0)
      {
        subTree.parentNode.leftNode = null;
      } 
      else if(subTree.parentNode.rightNode != null && subTree.parentNode.rightNode.word.compareTo(word) == 0) 
      {
        subTree.parentNode.rightNode = null;
      }
      return(true);
    }
    else if(word.compareTo(subTree.word) > 0) 
    {
      if(subTree.rightNode == null) 
      {
        return(false);
      }
      this.deleteWord(subTree.rightNode, word);
    }
    else 
    {
      if(subTree.leftNode == null) 
      {
        return(false);
      }
      this.deleteWord(subTree.leftNode, word);
    }
    return(false);
  }
  
  public void deleteTree() 
  {
    this.root = null;
  }
  
  public void printInOrder(String word)
  {
    System.out.println(word);
  }
  
  public void printHistogram(String word, int indWordCount)
  {
    if(searchForWord(word, subTree) == true)
    {
      indWordCount++;
    }
    else
    {
      System.out.println(word + " " + indWordCount);
      indWordCount++;
    }
  }
}