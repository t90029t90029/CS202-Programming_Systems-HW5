//Shang Chun, Lin  CS202 #assignment 5
//this is a file for the main

package com.company;
import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        menu my_list;
        my_list = new menu();

        my_list.read_in();

        Scanner input = null;
        int choose = 0;
        System.out.println("Hi, this is a food list program to record what you want to eat.");
        System.out.println("Now, please choose a service you would like to use. You have to enter a number.");
        System.out.println("1 for inserting an new vendor in the bucket list,");
        System.out.println("2 for inserting an new food in a specific vendor's list,");
        System.out.println("3 for displaying the whole list,");
        System.out.println("4 for retrieving an food item from a vendor's list,");
        System.out.println("5 for removing a food item from a specific vendor's list,");
        System.out.println("6 for removing a vendor from the bucket list,");
        System.out.println("7 for removing the whole bucket list,");
        System.out.println("8 for quitting the program.");

        input = new Scanner(System.in);
        choose = input.nextInt();

        while(choose > 8 || choose < 1){
            System.out.println("The number is out of range.");
            input = new Scanner(System.in);
            choose = input.nextInt();
        }

        while(choose != 8) {
            if (choose == 1) {
                if(my_list.add_vendor() != 0){
                    System.out.println("We have inserted it.");
                }
            }
            else if (choose == 2) {
                if(my_list.add_food() != 0){
                    System.out.println("We have inserted it.");
                }
            }
            else if (choose == 3) {
                System.out.println("We have displayed " + my_list.display() + " items for you.");
            }
            else if (choose == 4) {
                food to_found = null;
                if(my_list.retrieve(to_found) != 0){
                    System.out.println("We have found it.");
                    to_found.display();
                }
            }
            else if (choose == 5) {
                if(my_list.remove_food() != 0){
                    System.out.println("We have removed it.");
                }
            }
            else if (choose == 6) {
                if(my_list.remove_vendor() != 0){
                    System.out.println("We have removed it.");
                }
            }
            else if (choose == 7) {
                if(my_list.remove_all() != 0) {
                    System.out.println("The list is clear now.");
                }
            }

            System.out.println("Now, please choose a service you would like to use. You have to enter a number.");
            System.out.println("1 for inserting an new vendor in the bucket list,");
            System.out.println("2 for inserting an new food in a specific vendor's list,");
            System.out.println("3 for displaying the whole list,");
            System.out.println("4 for retrieving an food item from a vendor's list,");
            System.out.println("5 for removing a food item from a specific vendor's list,");
            System.out.println("6 for removing a vendor from the bucket list,");
            System.out.println("7 for removing the whole bucket list,");
            System.out.println("8 for quitting the program.");

            input = new Scanner(System.in);
            choose = input.nextInt();

            while (choose > 8 || choose < 1) {
                System.out.println("The number is out of range.");
                input = new Scanner(System.in);
                choose = input.nextInt();
            }
        }
    }
}
