//Shang Chun, Lin  CS202 #assignment 5
//this is a file to implement a node class for LLL
package com.company;

public class node {
    protected food data;
    protected node next;

    public node(){
        data = null;
        next = null;
    }

    //serve for the read in function
    public node(final wrap_up source){
        if(source.getFood_kind().compareToIgnoreCase("Boba") == 0){
            this.data = new boba(source);
        }
        else if(source.getFood_kind().compareToIgnoreCase("Pizza") == 0){
            this.data = new pizza(source);
        }
        if(source.getFood_kind().compareToIgnoreCase("Steak") == 0){
            this.data = new steak(source);
        }

        next = null;
    }

    public node go_next(){
        return this.next;
    }
    public void setnext(node source){
        this.next = source;
    }

    public food get_data(){
        return this.data;
    }
    public void setdata(char answer){
        if(answer == 'B'){
            this.data = new boba();
        }
        else if(answer == 'P'){
            this.data = new pizza();
        }
        else {
            this.data = new steak();
        }
    }
}
