/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.entity;

/**
 *
 * @author parlad
 */
public class Entity {
     String title , adUrl ,imgName ,seller,price;

    public Entity() {
    }

    public Entity(String title, String adUrl, String imgName, String seller, String price) {
        this.title = title;
        this.adUrl = adUrl;
        this.imgName = imgName;
        this.seller = seller;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Entity{" + "title=" + title + ", adUrl=" + adUrl + ", imgName=" + imgName + ", seller=" + seller + ", price=" + price + '}';
    }
     
     public String toCSV() {
        return   title + "," + adUrl + "," + imgName + "," + seller + "," + price + "\r\n";
    }
     
}
