public class BST<T extends Comparable<T>> {

    public class  BSTNode<T extends Comparable<T>> {
        protected BSTNode<T> left, right;
        private T data;

        public BSTNode(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setRight(BSTNode<T> right) {
            this.right = right;
        }

        public void setLeft(BSTNode<T> left) {
            this.left = left;
        }

        public T getData() {
            return (T) this.data;
        }

        public BSTNode<T> getRight() {
            return this.right;
        }

        public BSTNode<T> getLeft() {
            return this.left;
        }
    }
    BSTNode root;

    //constructor
    public void BSTNode (){
        root = null;
    }

    //insert
    public void insert(Comparable value){
        root = insert (root, value);
    }

    public BSTNode insert(BSTNode node, Comparable value){
        if(node==null){
            BSTNode n = new BSTNode(value);
            return n;
        } else if(node.getData().compareTo(value)<0){ //if the node being viewed is less than one we are inserting than we want to put on the node's right cz >than
            node.right = insert(node.right, value);
        } else{
            //if the node being viewed is greater than one we are inserting than we want to put on the node's left cz we know its less than the current node
            node.left = insert( node.left, value);
        }

        //print();
        //System.out.println("------");
        return node;
    }
    //find function
    public boolean find(Comparable value){
        return find(root, value);
    }
    public boolean find (BSTNode root, Comparable value){
        if(root == null){
            return false;
        } //tree is empty && its the base case
        BSTNode curr = root;
        //System.out.println("value is " + value + " curr is " + curr.getData());
        if(curr.getData().compareTo(value)==0) {
            System.out.println("woot");
            return true;
        }
        else if (curr.getData().compareTo(value)>0) {
            return find(curr.left, value);
        }
        else {//comparTo==1
            return find(curr.right, value);
        }
    }

    public void print() {
        print(root);
    }
    //print
    private void print(BSTNode node){
        if(node != null){
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    public void delete (Comparable value) {
        root = delete(root, value);
    }

    //delete
    private BSTNode delete (BSTNode node, Comparable value){
        if(node == null){
            return null;
        }
        if(node.getData().compareTo(value)==0){
            if(node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else{
                if(node.right.left == null){
                    node.data = node.right.getData();
                    node.right = node.right.right;
                    return node;
                } //end of it
                else{
                    node.data = removeSmallest(node.right);
                    return node;
                } // end of else
            } //end of else
        } //end of if
        else if (node.getData().compareTo(value)>0){
            node.setLeft(delete(node.getLeft(), value)); //sets new right
        }
        else{
            node.setRight(delete(node.getRight(), value)); //sets new left
        }
        return node;
    }
    Comparable <T> removeSmallest (BSTNode node){
        if(node.left.left==null){
            BSTNode smallest = node.left.right;
            node.right = node.left.right;
            return smallest.getData();
        }//end of if
        else{
            return removeSmallest(node.left);
        }//end of else
    }
}
