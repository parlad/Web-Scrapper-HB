/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.program;

import com.neupane.webscrapperhb.ImageSaver;
import com.neupane.webscrapperhb.SaveToCsv;
import com.neupane.webscrapperhb.Scrapping;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author parlad
 */
public class main {

    public static void main(String[] args) throws IOException {
        System.out.println("============================================");
        System.out.println("Welcome to my web scrapper");
        System.out.println("---------------------------------------------");
        System.out.println("===============================================");
        
        HBScrapper sc = new HBScrapper();
        sc.getUrl();
    }
}
