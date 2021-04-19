//Shang Chun, Lin  CS202 #assignment 5
//this is a file to implement a node class for BST
package com.company;

public class t_node {
    protected vendor data;
    protected t_node left;
    protected t_node right;

    public t_node(){
        data = null;
        left = null;
        right = null;
    }


    //serve for the read in function
    public t_node(final wrap_up source){
        data = new vendor(source);
        left = null;
        right = null;
    }

    public t_node go_left() {
        return this.left;
    }
    public void setleft(t_node source){
        this.left = source;
    }
    public t_node go_right(){
        return this.right;
    }
    public void setright(t_node source){
        this.right = source;
    }

    public vendor get_data(){
        return this.data;
    }
    public void setdata(vendor source){
        this.data = source;
    }
}
