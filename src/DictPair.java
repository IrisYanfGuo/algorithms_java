/**
 * Created by Iris on 2016/11/14.
 */
public class DictPair implements Comparable{
    private Object key;
    private Object value;

    public DictPair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "DictPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int compareTo(Object o){
        DictPair a= (DictPair)o;
        return ((Comparable)key).compareTo(a.getKey());
    }


}
