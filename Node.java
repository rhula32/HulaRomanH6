public class Node
{
  String word;
  Node left;
  Node right;
  
  Node(String wo)
  {
    word = wo;
    left = null;
    right = null;
  }
  
  Node(String wo, Node leftLeaf, Node rightLeaf)
  {
    word = wo;
    left = leftLeaf;
    right = rightLeaf;
  }
}