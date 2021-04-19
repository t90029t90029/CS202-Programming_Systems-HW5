//Shang Chun, Lin  CS202 #assignment 5
//this is a file to implement a temporarily bag for reading in an external file
//perform like a struct, so it has setters and getters.  Just for reading in!

package com.company;

public class wrap_up {
    protected String vendor_name;
    protected String food_kind;
    protected String food_name;
    protected String food_size;
    protected String feature1;
    protected String feature2;

    public String getVendor_name(){
        return vendor_name;
    }
    public void setVendor_name(final String source) {
        vendor_name = source;
    }

    public String getFood_kind(){
        return food_kind;
    }
    public void setFood_kind(final String source){
        food_kind = source;
    }

    public String getFood_name(){
        return food_name;
    }
    public void setFood_name(final String source){
        food_name = source;
    }

    public String getFood_size(){
        return food_size;
    }
    public void setFood_size(final String source){
        food_size = source;
    }

    public  String getFeature1(){
        return feature1;
    }
    public void setFeature1(final String source){
        feature1 = source;
    }

    public  String getFeature2(){
        return feature2;
    }
    public void setFeature2(final String source){
        feature2 = source;
    }
}
