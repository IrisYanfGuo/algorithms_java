import java.util.DoubleSummaryStatistics;

/**
 * ClassName:Graph
 * Version:1.0
 * Time : 12:35 11.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Graph {
    private Matrix data;
    private int nrNodes;

    public Graph(int nrNodes) {
    data = new Matrix(nrNodes);
    }

    public void addEdge(int from,int to,double w){
        data.set(from,to,w);
    }

    public double getEdge(int from,int to){
        return (Double)data.get(from, to);
    }

}
