/**
 * ClassName:ChessBoard
 * Version:1.0
 * Time : 11:08 02.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class ChessBoard implements Comparable {

    private int size;
    private boolean board[][];
    private int count = 0;


    public ChessBoard() {
    }

    public ChessBoard(int n ){

    }

    public ChessBoard(ChessBoard anotherChessBoard){

    }

    public int getCount() {
        return count;
    }

    public void set(int i ,int j, boolean value){}

    public LinkedList<ChessBoard> successors(){return null;}

    public boolean goalReached(){return false;}

    public void print(){}

    public boolean canAdd(int x, int y){return false;}

    public int compareTo(Object o){
        return 0;
    }

}
