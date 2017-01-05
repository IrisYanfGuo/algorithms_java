
/**
 * Created by Iris on 2016/11/14.
 */


//how  to use the Vector I wrote to solve
public class Dictionary<K extends Comparable<K>,V> {
    private Vector<DictPair> data;
    public Dictionary(){
        // create a vector with the capacity 100.
        data = new Vector<>(100);
    }

    public class DictPair{
        private K key;
        private V value;

        public DictPair(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int compareTo(Object o){
            DictPair a= (DictPair)o;
            return key.compareTo(a.getKey());
        }

        @Override
        public String toString() {
            return "DictPair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    @Override
    public String toString() {
        return  data.toString();
    }

    public void add(K key, V value){
        DictPair o = new DictPair(key,value);
        if (findPosition(key)!=-1) {
            data.set(findPosition(key),o);
        }else{
        data.addFirst(o);}
    }

    public int findPosition(K key){

        for(int i =0;i<data.size();i++){
            if (((DictPair)(data.get(i))).getKey() == key){
                return i;
            }
        }
        return -1;
    }

    public V find(Object key){
        for (int i =0;i<data.size();i++){
            if (((DictPair)data.get(i)).getKey() == key)
                return ((DictPair)data.get(i)).getValue();
        }
        return null;
    }
}
