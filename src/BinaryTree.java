import java.util.Objects;

/**
 * The type Binary tree.
 */
public class BinaryTree {


    public class TreeNode implements Comparable {
        protected Comparable value;
        protected TreeNode leftNode;
        protected TreeNode rightNode;
        protected TreeNode parentNode;


        public TreeNode(Comparable value, TreeNode leftNode, TreeNode rightNode, TreeNode parentNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.parentNode = parentNode;
        }

        public TreeNode(Comparable value) {
            this(value, null, null, null);
        }

        public int compareTo(Object arg0) {
            TreeNode node2 = (TreeNode) arg0;
            return value.compareTo(node2.value);
        }

        public TreeNode getLeftTree() {
            return leftNode;
        }

        public TreeNode getRightTree() {
            return rightNode;
        }

        public TreeNode getParentNode() {
            return parentNode;
        }

        public void setLeftTree(TreeNode leftNode) {
            this.leftNode = leftNode;
        }


        public void setRightTree(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "" + value;
        }

        public Comparable getValue() {
            return value;
        }
    }

    TreeNode root;

    public BinaryTree() {
        root = null;
    }


    //in a recursive way, and also can use a not recursive way
    private TreeNode findTreeNode(Comparable element, TreeNode current) {
        if (current == null) {
            return null;
        } else if (element.compareTo(current.value) < 0) {
            return findTreeNode(element, current.getLeftTree());
        } else if (element.compareTo(current.value)>0){
            return findTreeNode(element, current.getRightTree());
        }else {
            return current;
        }
    }

    public TreeNode findTreeNode(Comparable element){
        return findTreeNode(element,root);
    }

    public TreeNode getRoot() {
        return root;
    }

    //used in insertNode, insert the node in a recursive way
    private void insertAtNode(Comparable element, TreeNode current, TreeNode parent) {
        if (current == null) {
            TreeNode newNode = new TreeNode(element);
            // if the node is empty, but we have a parent
            if (parent != null) {
                if (parent.compareTo(newNode) > 0) {
                    parent.setLeftTree(newNode);
                } else {
                    parent.setRightTree(newNode);
                }
            } else {
                root = newNode;
            }

            newNode.parentNode = parent;
        } else if (element.compareTo(current.value) == 0) {

        } else if (element.compareTo(current.value) > 0) {
            insertAtNode(element, current.getRightTree(), current);
        } else {
            insertAtNode(element, current.getLeftTree(), current);
        }
    }

    public void insertNode(Comparable el) {
        insertAtNode(el, root, null);
    }

    // used in remove the node
    private TreeNode minNode(TreeNode current) {
        if (current == null) {
            return null;
        } else if (current.getLeftTree() == null) {
            return current;
        } else {
            return minNode(current.getLeftTree());
        }
    }

    // used in remove the node
    public TreeNode maxNode(TreeNode current) {
        if (current == null) {
            return null;
        } else if (current.getRightTree() == null) {
            return current;

        } else {
            return maxNode(current.getRightTree());
        }


    }

    // print the node from middle-> left->right
    private void printMid(TreeNode n) {
        if (n != null) {

            System.out.print(n);
            System.out.print(" ");
            printMid(n.getLeftTree());
            printMid(n.getRightTree());

        }
    }

    public void printMid() {
        System.out.print("[");
        printMid(root);
        System.out.print("]");
        System.out.println();

    }

    private void printLeft(TreeNode n) {
        if (n != null) {
            printLeft(n.getLeftTree());
            System.out.print(n);
            System.out.print(" ");
            printLeft(n.getRightTree());

        }
    }

    public void printLeft() {
        System.out.print("[");
        printLeft(root);
        System.out.print("]");

        System.out.println();
    }

    //use traverse from left->middle->right
    private String toString(TreeNode current) {
        String s = "";
        if (current != null) {
            s = s + toString(current.leftNode);
            s = s + current + " ";
            s = s + toString(current.rightNode);
        }
        return s;
    }


    public void recPrint() {
        System.out.print("[");

        Stack t = new Stack();
        t.push(root);
        while (t.size() > 0) {
            TreeNode n = (TreeNode) t.pop();
            System.out.print(n.value);
            System.out.print(" ");

            if (n.getLeftTree() != null) {
                t.push(n.getLeftTree());
            }
            if (n.getRightTree() != null) {
                t.push(n.getRightTree());
            }

        }
        System.out.print("]");

        System.out.println();
    }


    private void printLayer(Stack<TreeNode> n) {
        Stack t = new Stack();
        // where bug appears, lack of the statement if n.size()<=0, infinite recursive funtion.
        if (n.size() <= 0) {
            return;
        }
        while (n.size() > 0) {
            TreeNode temp = n.pop();
            System.out.print(temp);
            System.out.print(" ");
            if (temp.getLeftTree() != null) {
                t.push(temp.getLeftTree());
            }
            if (temp.getRightTree() != null) {
                t.push(temp.getRightTree());
            }
        }
        printLayer(t);
    }

    /**
     * Print layer. print the tree layer by layer
     */
    public void printLayer() {
        System.out.print("[");
        Stack troot = new Stack();
        troot.push(root);
        printLayer(troot);
        System.out.print("]");
        System.out.println();
    }


    public void remove(Comparable element) {
        myRemoveNode1(element, root);

    }


    // First,you need to get full understanding of transplant.
    // the same as in PPT, divided the situation into three kind
    private void removeNode(Comparable element, TreeNode current) {
        if (current == null) return;
        else if (element.compareTo(current.value) == 0) {
            if (current.leftNode == null) {
                transplant(current, current.rightNode);
            } else if (current.rightNode == null) {
                transplant(current, current.rightNode);
            } else {
                TreeNode y = minNode(current.rightNode);

                if (y.parentNode != current) {
                    transplant(y, y.rightNode);
                    y.rightNode = current.rightNode;
                    y.rightNode.parentNode = y;
                }
                transplant(current, y);
                y.leftNode = current.leftNode;
                y.leftNode.parentNode = y;
            }
        } else if (element.compareTo(current.value) > 0) {
            removeNode(element, current.getRightTree());
        } else {
            removeNode(element, current.getLeftTree());
        }
    }

    // transplant two trees
    private void transplant(TreeNode oldNode, TreeNode newNode) {
        if (oldNode == root) {
            root = newNode;
        } else if (oldNode.parentNode.getLeftTree() == oldNode) {
            oldNode.parentNode.setLeftTree(newNode);
        } else {
            oldNode.parentNode.setRightTree(newNode);
        }
        if (newNode != null) {
            newNode.parentNode = oldNode.parentNode;
        }
    }

    // use the smallest element in the right tree to substitute
    private void myRemoveNode(Comparable element, TreeNode current) {
        if (current == null) return;
        if (element.compareTo(current.value) == 0) {
            if (current.rightNode == null) {
                transplant(current, current.leftNode);
            } else {
                TreeNode y = minNode(current.rightNode);

                transplant(y, y.rightNode);
                y.rightNode = current.rightNode;
                if (y.rightNode != null) {
                    //must consider the situation of if the rightNode is null，
                    y.rightNode.parentNode = y;
                }

                transplant(current, y);
                y.leftNode = current.leftNode;
                if (y.leftNode != null) {
                    y.leftNode.parentNode = y;
                }
            }
        } else if (element.compareTo(current.value) > 0) {
            myRemoveNode(element, current.getRightTree());
        } else {
            myRemoveNode(element, current.getLeftTree());
        }
    }

    // use the largest element in the leftTree to substitute.
    private void myRemoveNode1(Comparable element, TreeNode current) {
        if (current == null) return;//when  found the element
        if (element.compareTo(current.value) == 0) {
            if (current.getLeftTree() != null) {
                TreeNode t = maxNode(current.getLeftTree());


                transplant(t, t.leftNode);
                // bug appears here t.parentNode.rightnode = t.leftNode
                // since we have use the function transplant,if we write it again,it repeat the same thing and will cause bug
                if (t.leftNode != null) {
                    t.leftNode.parentNode = t.parentNode;
                }
                t.rightNode = current.rightNode;
                t.leftNode = current.leftNode;

                if (current.rightNode != null) {
                    current.rightNode.parentNode = t;
                }
                transplant(current, t);
            } else {
                transplant(current, current.getRightTree());
            }
        } else if (element.compareTo(current.value) < 0) {
            myRemoveNode1(element, current.getLeftTree());
        } else {
            myRemoveNode1(element, current.getRightTree());
        }
    }


    @Override
    //from left->middle->right
    public String toString() {
        return toString(root);
    }

    /**
     * Traverse. traverse all the element
     * and there is a Action Run abstract class,you can write code in it
     *
     * @param action the action
     */
    public void traverse(TreeAction action) {
        Queue<TreeNode> t = new Queue();
        t.push(root);
        while (!t.empty()) {
            TreeNode n = t.pop();
            action.run(n);
            if (n.getLeftTree() != null) {
                t.push(n.getLeftTree());
            }
            if (n.getRightTree() != null) {
                t.push(n.getRightTree());
            }
        }
    }


    /**
     * Print 1. use traverse function to print
     */
    public void print1() {
        traverse(new TreeAction() {
            @Override
            public void run(TreeNode node) {
                System.out.print(node);
                System.out.print(" ");
            }
        });
    }


    private Double averOnTraverse(TreeActionDouble action) {
        double sum = 0;
        double count = 0.0;
        Queue<TreeNode> t = new Queue<>();
        t.push(root);
        while (!t.empty()) {
            TreeNode n = t.pop();
            sum = sum + (int)action.run(n);
            count++;
            if (n.getLeftTree() != null) {
                t.push(n.getLeftTree());
            }
            if (n.getRightTree() != null) {
                t.push(n.getRightTree());
            }

        }
        return sum / count;
    }

    public Double average() {
        return averOnTraverse(new TreeActionDouble() {
            @Override
            public Comparable run(TreeNode treeNode) {
                return  treeNode.getValue();
            }
        });
    }


    private int depth(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            if (depth(t.getLeftTree()) > depth(t.getRightTree()))
                return depth(t.getLeftTree()) + 1;
            else
                return depth(t.getRightTree()) + 1;
        }
    }

    public int depth() {
        return depth(root);

    }

    private Comparable getBig(TreeNode t) {
        if (t.getRightTree() != null) {
            return getBig(t.getRightTree());
        } else {
            return t.getValue();
        }
    }

    public Comparable getBig() {
        return getBig(root);
    }

    private Comparable getSmall(TreeNode t) {
        if (t.getLeftTree() != null) {
            return getSmall(t.getLeftTree());
        } else {
            return t.getValue();
        }
    }

    public Comparable getSmaill() {
        return getSmall(root);
    }

    private void swapTree(TreeNode t) {
        if (t != null) {
            TreeNode t2 = t.getLeftTree();
            if (t.getRightTree() != null) {
                t.setLeftTree(t.getRightTree());

            }
            if (t2 != null) {
                t.setRightTree(t2);

            }
            swapTree(t.getLeftTree());
            swapTree(t.getRightTree());
        } else {
            return;
        }
    }

    public void swapTree() {
        swapTree(root);
    }


}
