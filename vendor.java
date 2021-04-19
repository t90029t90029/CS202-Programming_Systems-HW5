//Shang Chun, Lin  CS202 #assignment 5
//this is a file to implement a derived class for the list class
package com.company;
import java.util.Scanner;
import java.lang.String;

public class vendor extends list{
    protected String name;
    protected Scanner input=null;

    public vendor(){
        name = null;
    }

    //serve for the read in function
    public vendor(final wrap_up source){
        name = source.getVendor_name();
        super.insert(source);
    }

    public void setname() {
        System.out.println("Please enter a name for the vendor you want to add in the menu.");
        input = new Scanner(System.in);
        name = input.nextLine();
    }

    public int insert(){
        if(name == null){
            System.out.println("The vendor hasn't set up yet.");
            return 0;
        }
        return super.insert();
    }

    public int display(){
        if(name != null) {
            System.out.println("Vendor : " + name);
        }
        return super.display();
    }

    public int compare(final String source){
        if(source != null){
            return this.name.compareToIgnoreCase(source);
        }
        return 1;
    }
    public int retrieve(food to_found){
        System.out.println("Please enter a name of the food that you want to retrieve.");
        String a_name;
        input = new Scanner(System.in);
        a_name = input.nextLine();
        if(super.retrieve(a_name,to_found) != 0){
            return 1;
        }
        System.out.println("There is no matching name of the food in this vendor's food list.");
        return 0;
    }

    public int remove(){
        input = new Scanner(System.in);
        String to_remove;
        System.out.println("Please enter the name of the food you want to remove from the list.");
        to_remove = input.nextLine();

        if(super.remove(to_remove) != 0){
            return 1;
        }
        return 0;
    }

    public void remove_all(){
        super.remove_all();
        name = null;
    }
}
