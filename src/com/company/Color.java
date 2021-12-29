package com.company;

public enum Color {
    RED("red"),
    BLUE("blue");

    private final String color;

    public String getColor(){
        return this.color;
    }

    Color(String color){
        this.color=color;
    }
}
