/**
 * ClassName:Matrix
 * Version:1.0
 * Time : 12:37 11.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class Matrix {
    private Comparable key[][];

    public Matrix(int nrNodes) {
        key = new Comparable[nrNodes][nrNodes];
        for (int i =0;i<nrNodes;i++){
            for (int j = 0;j<nrNodes;j++){
                key[i][j] =0;
            }
        }
    }

    public void set(int row, int col, Comparable weigh) {
        key[row][col]=weigh;
    }

    public Comparable get(int row, int col){
        return key[row][col];
    }




}
