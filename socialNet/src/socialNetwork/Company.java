package socialNetwork;

import datastru.LinkedList;

/**
 * Created by Iris on 2016/11/7.
 */
public class Company extends Profile{
    private String name;
    private String username;
    private LinkedList<Message> ad;

    public Company() {
        ad = new LinkedList();
    }

    public Company(String name) {
        this();
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void post(String a ){

    }



}
