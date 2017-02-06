/*
 * Copyright (c) 2017 CMPUT 301. University of Alberta - All rights reserved. You may use,
 * distribute, or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta. You can find a copy of the lisence in this project. Otherwise please
 * contact qpang@ualberta.ca
 */

package com.example.panchy.assignment1;

/**
 * This class is obj class of the people. <br> In this class,
 * i define all information of people and their setter and getter method. I also define the
 * create and tostring method of people in this class.
 *
 * @author pang qi
 * @version 1.1
 * @since 1.0
 */


public class People {

    private String name;
    private String date;
    private String neck;
    private String bust;
    private String chest;
    private String waist;
    private String hip;
    private String inseam;
    private String comment;

    /**
     * creat a new people obj with name and data
     * @param name
     * @param date
     */

    public People(String name,String date) {
        this.name = name;
        this.date=date;
        this.neck=" ";
        this.bust=" ";
        this.chest=" ";
        this.waist=" ";
        this.hip=" ";
        this.inseam=" ";
        this.comment="Customer just record by name.";
    }

    /**
     * creat new people obj with all information
     * @param _name
     * @param _date
     * @param _neck
     * @param _bust
     * @param _chest
     * @param _waist
     * @param _hip
     * @param _inseam
     * @param _comment
     */
    public  People(String _name,String _date,String _neck,String _bust,String _chest,String _waist,
                   String _hip,String _inseam,String _comment){
        this.name=_name;
        this.date=_date;
        this.neck=_neck;
        this.bust=_bust;
        this.chest=_chest;
        this.waist=_waist;
        this.hip=_hip;
        this.inseam=_inseam;
        this.comment=_comment;
    }


    /**
     * get name of people
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * set name
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get neck
     * @return neck
     */
    public String getNeck() {
        return neck;
    }

    /**
     * set neck
     * @param neck
     */
    public void setNeck(String neck) {
        this.neck = neck;
    }

    /**
     * get bust
     * @return bust
     */
    public String getBust() {
        return bust;
    }

    /**
     * set bust
     * @param bust
     */
    public void setBust(String bust) {
        this.bust = bust;
    }

    /**
     * get chest
     * @return chest
     */
    public String getChest() {
        return chest;
    }

    /**
     * set chest
     * @param chest
     */
    public void setChest(String chest) {
        this.chest = chest;
    }

    /**
     * get waist
     * @return waist
     */
    public String getWaist() {
        return waist;
    }

    /**
     * set waist
     * @param waist
     */
    public void setWaist(String waist) {
        this.waist = waist;
    }

    /**
     * get inseam
     * @return inseam
     */
    public String getInseam() {
        return inseam;
    }

    /**
     * set inseam
     * @param inseam
     */
    public void setInseam(String inseam) {
        this.inseam = inseam;
    }

    /**
     * get hip
     * @return hip
     */
    public String getHip() {
        return hip;
    }

    /**
     * set hip
     * @param hip
     */
    public void setHip(String hip) {
        this.hip = hip;
    }


    /**
     * get comment
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * set comment
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * return a string of all information of a people obj
     * @return string
     */
    @Override
    public String toString(){
        return "Date:"+date+" \nName:"+name+"\nNeck:"+neck+"\nBust:"+bust+"\nChest:"+chest
                +"\nWaist:"+waist+"\nHip:"+hip+"\nInseam:"+inseam+"\nComment:"+comment;
    }
}



