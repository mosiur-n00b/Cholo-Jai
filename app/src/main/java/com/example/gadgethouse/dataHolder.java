package com.example.gadgethouse;

public class dataHolder {
    String email,location,usermobile,userName,userNID,selection,userBkash;
    int numOfPerson,totalCost;

    public dataHolder(String email, String location, String usermobile, String userName, String userNID, String selection, String userBkash, int numOfPerson, int totalCost) {
        this.email = email;
        this.location = location;
        this.usermobile = usermobile;
        this.userName = userName;
        this.userNID = userNID;
        this.selection = selection;
        this.userBkash = userBkash;
        this.numOfPerson = numOfPerson;
        this.totalCost = totalCost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNID() {
        return userNID;
    }

    public void setUserNID(String userNID) {
        this.userNID = userNID;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getUserBkash() {
        return userBkash;
    }

    public void setUserBkash(String userBkash) {
        this.userBkash = userBkash;
    }

    public int getNumOfPerson() {
        return numOfPerson;
    }

    public void setNumOfPerson(int numOfPerson) {
        this.numOfPerson = numOfPerson;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
