/**
 * ClassName:ListGraph
 * Version:1.0
 * Time : 15:17 05.Jan 2017
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class ListGraph <K extends Comparable<K>>{

    private static  int INF = Integer.MAX_VALUE;

    public class Edge{
        int ivex;
        int weight;
        Edge toNode;
    }

    public class VNode {
        K data;
        Edge firstEdge;
    }

    private int mEdgNum;
    private VNode[] mVexs;

    public ListGraph() {
    }

}
