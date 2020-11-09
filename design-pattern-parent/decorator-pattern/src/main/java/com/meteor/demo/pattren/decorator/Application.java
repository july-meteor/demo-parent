package com.meteor.demo.pattren.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * created by Meteor on 2020/1/12
 */
public class Application {

    public static void main(String[] args) {

        try {
            InputStream inputStream  =   new FileInputStream("//");

            FileInputStream inputStream2 =   new FileInputStream("//");



            BufferedInputStream inputStrea1 = new BufferedInputStream(inputStream);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStream inputStream = null;
//        InputStream inputStream = new BufferedInputStream()；
    }
}
