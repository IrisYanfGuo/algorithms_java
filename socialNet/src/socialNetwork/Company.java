package socialNetwork;

import datastru.LinkedList;

/**
 * Created by Iris on 2016/11/7.
 * extend from profile, use to extend
 */
public class Company extends Profile{
    private String name;
    private String username;

    // use the ad to represent the ad posted by this company.
    private LinkedList<Ad> ad;

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
