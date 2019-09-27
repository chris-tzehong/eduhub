package com.example.android.eduhub;

public class Progress_Achievement {

    private String userID;
    private int maths1;
    private int maths2;
    private int addmaths1;
    private int addmaths2;
    private int physics1;
    private int physics2;
    private int chemistry1;
    private int chemistry2;
    private int biology1;
    private int biology2;
    private int first_achievement = 0;
    private int second_achievement = 0;

    public Progress_Achievement() {

    }

    public Progress_Achievement(String userID, int maths1, int maths2, int addmaths1, int addmaths2, int physics1, int physics2, int chemistry1, int chemistry2, int biology1, int biology2, int first_achievement, int second_achievement) {
        this.userID = userID;
        this.maths1 = maths1;
        this.maths2 = maths2;
        this.addmaths1 = addmaths1;
        this.addmaths2 = addmaths2;
        this.physics1 = physics1;
        this.physics2 = physics2;
        this.chemistry1 = chemistry1;
        this.chemistry2 = chemistry2;
        this.biology1 = biology1;
        this.biology2 = biology2;
        this.first_achievement = first_achievement;
        this.second_achievement = second_achievement;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getMaths1() {
        return maths1;
    }

    public void setMaths1(int maths1) {
        this.maths1 = maths1;
    }

    public int getMaths2() {
        return maths2;
    }

    public void setMaths2(int maths2) {
        this.maths2 = maths2;
    }

    public int getAddmaths1() {
        return addmaths1;
    }

    public void setAddmaths1(int addmaths1) {
        this.addmaths1 = addmaths1;
    }

    public int getAddmaths2() {
        return addmaths2;
    }

    public void setAddmaths2(int addmaths2) {
        this.addmaths2 = addmaths2;
    }

    public int getPhysics1() {
        return physics1;
    }

    public void setPhysics1(int physics1) {
        this.physics1 = physics1;
    }

    public int getPhysics2() {
        return physics2;
    }

    public void setPhysics2(int physics2) {
        this.physics2 = physics2;
    }

    public int getChemistry1() {
        return chemistry1;
    }

    public void setChemistry1(int chemistry1) {
        this.chemistry1 = chemistry1;
    }

    public int getChemistry2() {
        return chemistry2;
    }

    public void setChemistry2(int chemistry2) {
        this.chemistry2 = chemistry2;
    }

    public int getBiology1() {
        return biology1;
    }

    public void setBiology1(int biology1) {
        this.biology1 = biology1;
    }

    public int getBiology2() {
        return biology2;
    }

    public void setBiology2(int biology2) {
        this.biology2 = biology2;
    }

    public int getFirst_achievement() {
        return first_achievement;
    }

    public void setFirst_achievement(int first_achievement) {
        this.first_achievement = first_achievement;
    }

    public int getSecond_achievement() {
        return second_achievement;
    }

    public void setSecond_achievement(int second_achievement) {
        this.second_achievement = second_achievement;
    }
}
