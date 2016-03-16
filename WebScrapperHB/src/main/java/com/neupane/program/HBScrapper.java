/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.program;

import com.neupane.entity.Entity;
import com.neupane.webscrapperhb.ImageSaver;
import com.neupane.webscrapperhb.SaveToCsv;
import com.neupane.webscrapperhb.Scrapping;
import com.neupane.webscrapperhb.Zipping;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author parlad
 */
public class HBScrapper {

    int totalAds;

    public void getUrl() throws IOException {
        String url = "http://hamrobazaar.com/c98-consumer-electronics-ipod-and-portable-media-players";
        int offset = 0;
        System.out.println("The webscraper has started...");
        System.out.println("Scraping page 1 ...");
        getUrlConnection(url);
        System.out.println("Total ads : " + totalAds);
        for (int i = 0; i < (totalAds / 20 + 1); i++) {
            url = "http://hamrobazaar.com/c98-consumer-electronics-ipod-and-portable-media-players?catid=98&order=popularad&offset=" + offset;
            System.out.println("Sraping the page " + (i + 2) + "...");
            getUrlConnection(url);
            offset = offset + 20;
        }
        try {
            Zipping.zippingFile("F:\\Directory\\fileC\\ompressZip.zip", "F:\\Directory\\file");
        } catch (Exception ex) {
            ex.getMessage();
            System.err.println("Compression Error !");
        }

    }

    public static void getUrlConnection(String url) throws IOException {
        String content = Scrapping.getURLContent(url);
        //System.out.println(content);
        String regEx = "<div class='boxlink'>(.*?)href=\"(.*?)\"> <img src='(.*?)'(.*?)<b>(.*?)</b>(.*?)<td colspan=\"3\"><font class=\"txtsmall\" color=\"#000000\">(.*?)<img src='layout_images/ver_phone.jpg'(.*?)<b>(.*?)</b>(.*?)class='boxlink'>";
        String regEx1 = "Showing <b>1</b> to <b>20</b> of total <b>(.*?)</b";

        String rexExALT1 = "<div class='boxlink'>(.*?)href=\"(.*?)\"> <img src='(.*?)'(.*?)<b>(.*?)</b>(.*?)<td colspan=\"3\"><font class=\"txtsmall\" color=\"#000000\">(.*?)<font style (.*?)<font class=\"txtsmall\" color=\"#000000\">(.*?)</font>(.*?)class='boxlink'>";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(content);
        List<String> listAds = new ArrayList<>();
        int i = 0;
        while (matcher.find()) {
            i++;
            System.out.println("Title:   " + matcher.group(5));
            String seller = matcher.group(7).split("<")[0];
            System.out.println("Seller       :   " + seller);
            System.out.println("Price        :   " + matcher.group(9));
            System.out.println("ImageUrl     :   " + matcher.group(3));
            System.out.println("UrlAd        :   " + matcher.group(2));

            String[] imageStack = matcher.group(3).split("/");
            String imageName = imageStack[imageStack.length - 1];
            new ImageSaver().saveTOImage(matcher.group(3), imageName);
            listAds.add(new Entity(matcher.group(5), matcher.group(2), imageName, seller, matcher.group(9)).toCSV());
        }
        try {
            SaveToCsv.saveToCSV(listAds);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
