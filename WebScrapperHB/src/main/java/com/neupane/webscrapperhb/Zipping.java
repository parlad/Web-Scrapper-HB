/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.webscrapperhb;

import java.io.File;

/**
 *
 * @author parlad
 */
public class Zipping {

    public static void zippingFile(String name, String dir) {
        File files;
        files = new File("F:\\Directory\\file");
        files = new File("F:\\Directory\\image");
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
    }
}
