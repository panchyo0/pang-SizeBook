package com.example.panchy.assignment1;



/**
 * Created by Panchy on 2017/1/30.
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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getInseam() {
        return inseam;
    }

    public void setInseam(String inseam) {
        this.inseam = inseam;
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return "Date:"+date+" \nName:"+name+"\nNeck:"+neck+"\nBust:"+bust+"\nChest:"+chest+"\nWaist:"+waist+"\nHip:"+hip+"\nInseam:"+inseam+"\nComment:"+comment;
    }
}



