//Shang Chun, Lin  CS202 #assignment 5
//this is a file to implement a derived class for the hierarchy
package com.company;
import java.util.Scanner;
import java.lang.String;

public class pizza extends food{
    protected String topping;
    protected String crust;
    protected Scanner input=null;

    public pizza(){
        topping = null;
        crust = null;
        input = new Scanner(System.in);
    }
    public pizza(final pizza source){
        if (source != null) {
            topping = new String(source.topping);
            crust = new String(source.crust);
        }
        super.insert(source);
    }

    //serve for the read in function
    public pizza(final wrap_up source){
        super.insert(source);
        if (source != null) {
            topping = new String(source.getFeature1());
            crust = new String(source.getFeature2());
        }
    }

    public int insert(){
        if(super.insert(1) == 1) {
            System.out.println("Please enter what kind of topping.");
            topping = input.nextLine();
            System.out.println("Please enter what kind of crust.");
            crust = input.nextLine();
        }
        return 1;
    }
    public void display(){
        super.display(1);
        System.out.println("Topping : " + topping);
        System.out.println("Crust : " + crust);
        System.out.println();
        return;
    }
    public int retrieve(String name_to_found,food to_found){
        if(this == null){
            return 0;
        }
        if(super.compare(name_to_found) == 0){
            to_found = new pizza(this);
        }
        return 1;
    }

}
