//Shang Chun, Lin  CS202 #assignment 5
//this is a file to implement a derived class for the hierarchy
package com.company;
import java.util.Scanner;
import java.lang.String;

public class steak extends food{
    protected String flavor;
    protected String degree;
    protected Scanner input=null;

    public steak(){
        flavor = null;
        degree = null;
        input = new Scanner(System.in);
    }
    public steak(final steak source){
        if (source != null) {
            flavor = new String(source.flavor);
            degree = new String(source.degree);
        }
        super.insert(source);
    }

    //serve for the read in function
    public steak(final wrap_up source){
        super.insert(source);
        if (source != null) {
            flavor = new String(source.getFeature1());
            degree = new String(source.getFeature2());
        }
    }

    public int insert(){
        if(super.insert(1) == 1) {
            System.out.println("Please enter what kind of flavor.");
            flavor = input.nextLine();
            System.out.println("Please enter how would you like your steak to be cooked?");
            degree = input.nextLine();
        }
        return 1;
    }
    public void display(){
        super.display(1);
        System.out.println("Flavor : " + flavor);
        System.out.println("Degree : " + degree);
        System.out.println();
        return;
    }
    public int retrieve(String name_to_found,food to_found){
        if(this == null){
            return 0;
        }
        if(super.compare(name_to_found) == 0) {
            to_found = new steak(this);
        }
        return 1;
    }

}
