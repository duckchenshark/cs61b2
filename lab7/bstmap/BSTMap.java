package bstmap;

public class BSTMap <K extends Comparable<K>,V>
{
    private Node root;

    private class Node{
        private K key;
        private V val;
        private Node left,right;
        private int size;
    }

    public void clear(){
        if(root.key==null){
            return;
        }
       

    }

    private void help_clear(Node node){
        if(node.key==null){
            return;
        }
        if(node.left.key!=null){

        }
        
    }
}
