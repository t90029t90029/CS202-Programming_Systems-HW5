//Shang Chun, Lin  CS202 #assignment 5
//this is a file to hold the whole BST
package com.company;
import java.util.Scanner;
import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;

public class menu {
    protected t_node root;
    protected Scanner input = null;
    protected Scanner readin = null;

    protected t_node read_in(t_node root,final wrap_up source){
        //add a new vendor at leaf
        if(root == null){
            root = new t_node(source);
            return root;
        }

        //add a new food in a specific vendor's LLL list
        if(root.get_data().compare(source.getVendor_name()) == 0){
            //function overloading -> invoke its super's function list::insert(wrap_up source)
            root.get_data().insert(source);
            return root;
        }

        if(root.get_data().compare(source.getVendor_name()) > 0){
            root.setleft(read_in(root.go_left(),source));
        }
        else{
            root.setright(read_in(root.go_right(),source));
        }
        return root;
    }
    protected void read_in(final wrap_up source){
        int count = 0;
        if(this.root == null) {
            this.root = new t_node(source);
        }
        else{
            this.root = read_in(this.root,source);
        }
    }
    public void read_in() throws FileNotFoundException {
        File file = new File("C:\\Users\\user\\ideaProjects\\project\\src\\com\\company\\external_text");
        readin = new Scanner(file);
        readin.useDelimiter("//|\n");
        wrap_up hold = new wrap_up();

        hold.setVendor_name(readin.next());

        while (readin.hasNextLine()) {        //only this place has an iterative loop
            hold.setFood_kind(readin.next());
            hold.setFood_name(readin.next());
            hold.setFood_size(readin.next());
            hold.setFeature1(readin.next());
            hold.setFeature2(readin.next());

            this.read_in(hold);

            if(readin.hasNextLine()){
                hold.setVendor_name(readin.next());
            }

        }

        readin.close();
    }

    protected int add_food(t_node root,String to_find){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.get_data().compare(to_find) == 0){          //to_find == root.data
            if(root.get_data().insert() != 0){
                System.out.println("Success.");
                return 1;
            }
        }

        if(root.get_data().compare(to_find) > 0) {          //to_find < root.data
            count += add_food(root.go_left(), to_find);
        }
        else {                                              //to_find > root.data
            count += add_food(root.go_right(), to_find);
        }
        return count;
    }
    public int add_food(){
        System.out.println("Please enter a name of the vendor that you want to add a new food into the list.");
        input = new Scanner(System.in);
        String to_find;
        to_find = input.nextLine();
        return add_food(root,to_find);
    }

    protected  int add_vendor(t_node root,vendor to_add){
        if(root == null){
            root = new t_node();
            root.setdata(to_add);
            root.setleft(null);
            root.setright(null);
            return 1;
        }
        int count = 0;

        if(root.get_data().compare(to_add.name) > 0) {
            count += add_vendor(root.go_left(), to_add);
        }
        else {
            count += add_vendor(root.go_right(), to_add);
        }

        return count;
    }
    public int add_vendor(){
        vendor to_add = new vendor();
        to_add.setname();
        return add_vendor(root,to_add);
    }

    protected int display(t_node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.get_data().display() != 0){
            ++count;
        }

        count += display(root.go_left());
        count += display(root.go_right());

        return count;
    }
    public int display(){
        if(root == null){
            System.out.println("The vendor list is empty now.");
            return 0;
        }
        return display(root);
    }

    protected int retrieve(t_node root,String vendor_name,food to_find){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.get_data().compare(vendor_name) == 0){
            return root.get_data().retrieve(to_find);
        }
        if(root.get_data().compare(vendor_name) > 0) {
            count += retrieve(root.go_left(),vendor_name,to_find);
        }
        else {
            count += retrieve(root.go_right(),vendor_name,to_find);
        }
        return count;
    }
    public int retrieve(food to_find){
        if(root == null){
            return 0;
        }
        System.out.println("Please enter a name of the vendor that you want to search.");
        String a_name;
        input = new Scanner(System.in);
        a_name = input.nextLine();

        return retrieve(root,a_name,to_find);
    }

    protected int remove_food(t_node root,String vendor_name){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.get_data().compare(vendor_name) == 0){
            return root.get_data().remove();
        }
        if(root.get_data().compare(vendor_name) > 0) {
            count += remove_food(root.go_left(),vendor_name);
        }
        else {
            count += remove_food(root.go_right(),vendor_name);
        }
        return count;
    }
    public int remove_food(){
        if(root == null){
            System.out.println("The vendor list is empty now.");
            return 0;
        }
        System.out.println("Please enter a name of the vendor that you want to search (and remove a food).");
        String a_name;
        input = new Scanner(System.in);
        a_name = input.nextLine();

        return remove_food(root,a_name);
    }

    protected int manage_ios(t_node root,vendor ios){
        t_node hold;
        if(root.go_left() == null){
            ios = root.get_data();
            root.setdata(null);

            if(root.go_right() != null) {
                hold = root.go_right();
                root.setright(null);
                root = hold;
            }
            else{
                root = null;
            }
            return 1;
        }
        return manage_ios(root.go_left(),ios);
    }
    protected int remove_vendor(t_node root,String vendor_name){
        if(root == null){
            return 0;
        }
        int count = 0;
        t_node hold;
        vendor ios = null;
        if(root.get_data().compare(vendor_name) == 0){
            if(root.go_left() == null && root.go_right() == null){
                root.get_data().remove_all();
                root.setdata(null);
                root = null;
            }
            else if(root.go_left() != null && root.go_right() == null){
                hold = root.go_left();
                root.get_data().remove_all();
                root.setdata(null);
                root.setleft(null);
                root = hold;
            }
            else if(root.go_left() == null && root.go_right() != null){
                hold = root.go_right();
                root.get_data().remove_all();
                root.setdata(null);
                root.setright(null);
                root = hold;
            }
            else{
                if(manage_ios(root.go_right(),ios) != 0){
                    root.get_data().remove_all();
                    root.setdata(ios);
                }
            }
            return 1;
        }

        if(root.get_data().compare(vendor_name) > 0) {
            count += remove_vendor(root.go_left(),vendor_name);
        }
        else {
            count += remove_vendor(root.go_right(),vendor_name);
        }
        return count;
    }
    public int remove_vendor(){
        if(root == null){
            System.out.println("The vendor list is empty now.");
            return 0;
        }
        System.out.println("Please enter a name of the vendor that you want to remove.");
        String a_name;
        input = new Scanner(System.in);
        a_name = input.nextLine();

        return remove_vendor(root,a_name);
    }

    protected t_node remove_all(t_node root){
        if(root == null){
            return null;
        }
        root.setleft(remove_all(root.go_left()));
        root.setright(remove_all(root.go_right()));

        root.get_data().remove_all();
        root.setleft(null);
        root.setright(null);
        root.setdata(null);
        root = null;

        return root;
    }
    public int remove_all(){
        if(root == null){
            return 0;
        }
        root = remove_all(root);
        return 1;
    }
}
