/**
 * ClassName:DictOnBiTree
 * Version:1.0
 * Time : 11:26 29.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class DictOnBiTree {

    private BinaryTree<Integer,Object> tree;
    public DictOnBiTree() {
        tree = new BinaryTree<>();
    }
    public void add(int key,Object value){
       tree.insertNode(key,value);
    }
   // public Comparable find(Object key){}


    @Override
    public String toString() {
        return tree.toString();
    }

    public void print(){
        System.out.println(toString());
    }



    // If do not use generics ,how to solve that??
   // private Object find(Object key,BinaryTree.TreeNode current){


    public Object find(Integer key){
      return (tree.findTreeNode(key)).getValue();
    }



}
