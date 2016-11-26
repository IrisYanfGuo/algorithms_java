import java.security.Key;
import java.util.*;

/**
 * Created by Iris on 2016/11/14.
 */


//how  to use the Vector I wrote to solve
public class Dictionary {
    private Vector data;

    public Dictionary(){
        // create a vector with the capacity 100.
        data = new Vector(100);
    }

    @Override
    public String toString() {
        return  data.toString();
    }

    public void add(Object key, Object value){
        DictPair o = new DictPair(key,value);
        if (findPosition(key)!=-1) {
            data.set(findPosition(key),o);
        }else{
        data.addFirst(o);}
    }

    public int findPosition(Object key){

        for(int i =0;i<data.size();i++){
            if (((DictPair)(data.get(i))).getKey() == key){
                return i;
            }
        }
        return -1;
    }

    public Object find(Object key){
        for (int i =0;i<data.size();i++){
            if (data.get(i).getKey() == key)
                return data.get(i).getValue();
        }
        return false;
    }
}
