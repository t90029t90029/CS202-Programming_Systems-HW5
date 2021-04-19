//Shang Chun, Lin  CS202 #assignment 5
//this is a file to hold the whole LLL
package com.company;
import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class list {
    protected node head;
    protected Scanner input=null;

    //serve for the read in function
    public void insert(final wrap_up source){
        node temp;
        temp = new node(source);

        if(head == null) {
            this.head = temp;
        }
        else{
            temp.setnext(head);
            this.head = temp;
        }
    }

    public int insert(){
        System.out.println("What kind of food do you want to keep tracking?");
        System.out.println("B for boba tea, P for pizza, S for steak.");
        System.out.println("The default choice will be steak.");
        input = new Scanner(System.in);
        char answer = input.next().charAt(0);
        answer = Character.toUpperCase(answer);

        node temp = new node();
        temp.setnext(null);
        temp.setdata(answer);
        if(temp.get_data().insert() == 0){
            return 0;
        }

        if(head == null){
            head = temp;
        }
        else{
            node hold = head;
            head = temp;
            head.setnext(hold);
        }
        return 1;
    }

    protected int display(node head){
        if(head == null){
            return 0;
        }
        head.get_data().display();
        return display(head.go_next()) + 1;
    }
    public int display(){
        if(head == null){
            return 0;
        }
        return display(head);
    }

    protected int retrieve(node head,String the_name,food to_found){
        if(head == null){
            return 0;
        }

        if(head.get_data().retrieve(the_name,to_found) == 1){
            return 1;
        }
        return retrieve(head.go_next(),the_name,to_found);
    }
    public int retrieve(String the_name,food to_found){
        if(head == null){
            return 0;
        }
        return retrieve(head,the_name,to_found);
    }

    protected int remove(node head,String to_remove){
        if(head == null){
            System.out.println("The item is not in the list.");
            return 0;
        }

        if(head.get_data().compare(to_remove) == 0){
            node hold = head.go_next();
            head.setnext(null);
            head = hold;
            return 1;
        }
        return remove(head.go_next(),to_remove);
    }
    public int remove(String to_remove){
        if(head == null){
            return 0;
        }
        return remove(head,to_remove);
    }

    public void remove_all(){
        if(head == null){
            return;
        }
        head = null;
    }
}
