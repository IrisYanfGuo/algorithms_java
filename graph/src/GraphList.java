
/**
 * ClassName:GraphList
 * Version:1.0
 * Time : 13:23 11.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class GraphList<K extends Comparable<K>> {

    public class Node{
        private K key;
        private LinkedList<Edge> edges;
        private boolean visited;

        public Node(K key) {
            this(key, false);
        }

        public Node(K key, boolean visited) {
            this.key = key;
            this.visited = visited;
            edges = new LinkedList<>();
        }

        public K getKey() {
            return key;
        }

        public boolean isVisited() {
            return visited;
        }

        @Override
        public String toString() {
            return
                    " " + key;  //+edges.toString();
        }


        @Override
        public boolean equals(Object obj) {
            return key.equals(((Node) obj).key);
        }

        // we can rewrite the for loop to find
        public int compareTo(Object node) {

            return ((Node) node).key.compareTo(key);
        }

        public int compareTo(K key2){
            return key.compareTo(key2);
        }
    }

    private class Edge {
        private Node toNode;
        private Comparable weight;

        public Edge(Node toNode, Comparable weight) {
            this.toNode = toNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(Edge:" + toNode.key +
                    ", weight:" + weight + ")";
        }
    }


    @Override
    public String toString() {
        String s = "";
        s = nodes.toString();
        return s;
    }

    private LinkedList<Node> nodes;

    public GraphList() {
        nodes = new LinkedList<>();
    }

    public void addNode(K key) {
        Node n = new Node(key);
        nodes.addLast(n);
    }

    // before you begin to search a graph, you need to set all the elements unvisited
    private void setAllVisitedF() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited = false;
        }
    }

    public Node findNode(K key) {
       /* for (int i = 0; i < nodes.size(); i++) {
            if (key == nodes.get(i).getKey()) {
                return nodes.get(i);

            }
        }*/
        Node n = new Node(key);
        return nodes.contains(n);
        //  System.out.println("can not find the node");

    }


    public void addEdge(K key1, K key2, Comparable weigh) {
        Node n1 = findNode(key1);
        Node n2 = findNode(key2);
        if ((n1 != null) && (n2 != null)) {
            Edge e = new Edge(n2, weigh);
            n1.edges.addFirst(e);
        } else {
            System.out.println(" can not find the node");
        }
    }

    // if does not provide weigh ,then set it to 1.
    public void addEdge(K key1, K key2) {
        addEdge(key1, key2, 1);
    }


    // using dfs to find path.
    public boolean findPath(K key1, K key2) {
        setAllVisitedF();
        Node n1 = findNode(key1);
        Node n2 = findNode(key2);
        Vector<Node> result;
        if ((n1 != null) && (n2 != null)) {
            Stack<Node> s = new Stack<>();

            while (s.size() > 0) {
                Node t = s.pop();
                t.visited = true;
                if (t.key == key2) {
                    return true;
                } else {
                    for (int i = 0; i < t.edges.size(); i++) {
                        Node tmp = t.edges.get(i).toNode;
                        if (!tmp.isVisited()) {
                            s.push(tmp);
                        }
                    }
                }
            }
            return false;
        } else {
            System.out.println(" can not find the node");
            return false;
        }
    }

    public Vector<Stack<Node>> findAllPath(K key1, K key2) {
        setAllVisitedF();
        Node n1 = findNode(key1);
        Node n2 = findNode(key2);
        Vector<Stack<Node>> result = new Vector<>();
        if ((n1 != null) && (n2 != null)) {
            Stack<Stack<Node>> s = new Stack<>();
            Stack<Node> a = new Stack<>();
            a.push(n1);
            s.push(a);
            while (s.size() > 0) {
                Stack<Node> tStack = s.pop();
                Node t = tStack.pop();
                if (t.key == key2) {
                    tStack.push(t);
                    result.addLast(tStack);
                    //test
                    System.out.println(tStack);
                } else {
                    t.visited = true;
                    tStack.push(t);
                    for (int i = 0; i < t.edges.size(); i++) {
                        Node tmp = t.edges.get(i).toNode;
                        if (!tmp.isVisited()) {
                            tStack.push(tmp);
                            s.push(tStack.deepcopy());
                            tStack.pop();
                        }
                    }
                }
            }
            return result;
        } else {
            System.out.println(" can not find the node");
            return null;
        }
    }


    //Depth first search, depth first traversals
    // recursion version
    // traverse all, and you must carefully control
    private void dfs(Node current) {
        Stack<Node> s = new Stack<>();
        s.push(current);
        current.visited = true;
        while (!s.isEmpty()) {
            Node tmp = s.pop();
            // if you want do other options, simply write your code here
            System.out.println(tmp);

            // push
            for (int i = 0; i < tmp.edges.size(); i++) {
                Node a = tmp.edges.get(i).toNode;
                if (!a.isVisited()) {
                    s.push(a);
                    a.visited = true;
                }
            }
        }

    }

    // using dfs to travel all the elements.
    public void dfs() {
        setAllVisitedF();

        Stack<Node> s = new Stack<>();
        if (nodes.size() == 0) return;
        s.push(nodes.get(0));
        while (s.size() > 0) {
            Node tmp = s.pop();
            dfs(tmp);
            for (int i = 0; i < nodes.size(); i++) {
                // scan, and add one unvisited node into Stack
                if (!nodes.get(i).isVisited()) {
                    s.push(nodes.get(i));
                    nodes.get(i).visited = true;
                }
            }
        }

    }

    private void bfs(Node x) {
        Queue<Node> q = new Queue<>();
        q.push(x);
        x.visited = true;

        while (!q.empty()) {
            Node tmp = q.pop();
            // if do other operations code write below
            System.out.println(tmp);

            for (int i = 0; i < tmp.edges.size(); i++) {
                Node t = tmp.edges.get(i).toNode;
                if (!t.isVisited()) {
                    q.push(t);
                    t.visited = true;
                }

            }
        }
    }


    public void bfs() {
        setAllVisitedF();
        Queue<Node> q = new Queue<>();
        if (nodes.size() == 0) return;

        q.push(nodes.get(0));
        nodes.get(0).visited = true;

        while (q.size() > 0) {
            Node tmp = q.pop();
            bfs(tmp);

            // scan one unvisited element and then add to the queue

            for (int i = 0; i < nodes.size(); i++) {
                Node tmp2 = nodes.get(i);
                if (!tmp2.isVisited()) {
                    q.push(tmp2);
                    tmp2.visited = true;
                    break;
                }
            }
        }

        System.out.println();
    }


    // use to test
    private void printins(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // topological sorting
    // check whether it has a cycle.

    public boolean topoSort() {
        setAllVisitedF();
        int index = 0;
        int num = nodes.size();
        int[] ins;               // in
        Vector<Node> tops;             // result
        Queue<Node> queue;    // queue use to document

        ins = new int[num];  // initialize
        tops = new Vector<>(num);
        queue = new Queue<>();

        // first , initialize ins[]
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < nodes.get(i).edges.size(); j++) {
                K tKey = nodes.get(i).edges.get(j).toNode.key;
                for (int k = 0; k < num; k++) {
                    if (tKey == nodes.get(k).key) {
                        ins[k]++;
                        break;
                    }
                }
            }
        }

        // printins(ins);

        // and ins 0 to the queue
        for (int i = 0; i < num; i++) {
            if (ins[i] == 0) {
                queue.push(nodes.get(i));
                nodes.get(i).visited = true;
            }
        }

        while (!queue.empty()) {
            Node tmp = queue.pop();
            tops.addFirst(tmp);

            index++;

            // update the value of ins
            for (int i = 0; i < tmp.edges.size(); i++) {
                K tKey = tmp.edges.get(i).toNode.getKey();
                for (int j = 0; j < nodes.size(); j++) {
                    if (nodes.get(j).getKey() == tKey) {
                        ins[j]--;
                        break;
                    }
                }
            }


            // add ins[i]=0 to the queue
            for (int i = 0; i < num; i++) {
                if (ins[i] == 0) {
                    if (!nodes.get(i).isVisited()) {
                        queue.push(nodes.get(i));
                        nodes.get(i).visited = true;
                    }
                }
            }

        }
        if (index != num) {
            System.out.println("Graph has a circle");
            return false;
        } else {
            for (int i = 0; i < num; i++) {
                System.out.println(tops.get(i).getKey());
            }
            return true;
        }

    }


    // shortest path algorithms
    // focus on finding single-source shortest path
    public void dijikstra(K key) {
        Node n = findNode(key);
        Vector<Edge> dist = new Vector<>();
        // first, initialize the dist
        setAllVisitedF();


    }

}
