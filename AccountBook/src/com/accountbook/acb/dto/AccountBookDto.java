package com.accountbook.acb.dto;

public class AccountBookDto {
    private String type;
    private int money;
    private String category;
    private String note;
    private String date;
    
    public AccountBookDto(String type,int money, String category,String note, String date){
        this.type = type;
        this.money = money;
        this.category = category;
        this.note = note;
        this.date = date;
    }
    public AccountBookDto(String date, String type,int money){
        this.date = date;
        this.type = type;
        this.money = money;
    }
    public AccountBookDto(String category){
        this.category = category;
    }


    public AccountBookDto(){}

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
    public void setMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }


    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }

    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return note;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }
}