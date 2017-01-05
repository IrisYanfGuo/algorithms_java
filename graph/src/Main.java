/**
 * ClassName:Main
 * Version:1.0
 * Time : 13:43 11.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Main {
    public Main() {
    }


    public static int getCurrentTime(){
        return (int)(System.currentTimeMillis()/1000L);
    }
    public static void main(String[] args) {
        GraphList a = new GraphList();
        a.addNode(40);
        a.addNode(20);
        a.addNode(30);
        a.addNode(10);
        a.addNode(50);
        a.addNode(60);
        a.addNode(70);

        a.addEdge(40, 20);
        a.addEdge(40, 10);
        a.addEdge(20, 10);
        a.addEdge(20, 30);
        a.addEdge(20, 60);
        a.addEdge(20, 50);
        a.addEdge(30, 60);
        a.addEdge(10, 30);
        a.addEdge(50, 70);
        a.addEdge(60, 70);


        a.dijkstra(40);

        System.out.println(a.findNode(40));

        // test find
        //   System.out.println( a.findPath(3,6));
        //  System.out.println( a.findPath(4,1));

        //test dfs
       // a.dfs();
       // System.out.println(a.toString());

      //  System.out.println();
        // test bfs
       // a.bfs();
        //a.topoSort();

        //test toposort when it has a circle

        GraphList btopo = new GraphList();
        btopo.addNode(1);
        btopo.addNode(2);
        btopo.addNode(3);
        btopo.addNode(4);
        btopo.addNode(5);
        btopo.addEdge(1,2);
        btopo.addEdge(2,1);
        btopo.addEdge(1,3);
        btopo.addEdge(2,3);
        btopo.addEdge(2,4);
        btopo.addEdge(3,4);
        btopo.addEdge(3,5);
        btopo.addEdge(5,4);
        btopo.addEdge(5,3);

        btopo.findAllPath(1,4);

      //  btopo.topoSort();



        GraphList dij = new GraphList();
        dij.addNode(1);
        dij.addNode(2);
        dij.addNode(3);
        dij.addNode(4);
        dij.addNode(5);
        dij.addNode(6);


       dij.addEdge(2,1);
       dij.addEdge(2,3);
       dij.addEdge(1,4);
       dij.addEdge(3,4);
       dij.addEdge(4,5);

        dij.dijkstra(2);



    }

}
