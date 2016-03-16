/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.webscrapperhb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 *
 * @author parlad
 */
public class SaveToCsv {

    public static void saveToCSV(List<String> list) throws MalformedURLException, IOException {
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        try (FileWriter writer = new FileWriter(new File("F://Directory//file//file.csv"), true)) {
            writer.write(builder.toString());
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
        System.out.println("Saved to CSV");
    }
}
