package com.bortnichuk.entity;

import com.bortnichuk.annotation.MyAnnotation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Window implements IWindow {

    private int left;
    private int top;
    private int right;
    private int bottom;
    private String color;

    @MyAnnotation
    public boolean isQuadratic(){
        return left == right && bottom == top && left == bottom;
    }

    public void changeColor(String newColor){
        color = newColor;
    }

    @MyAnnotation
    public void changeColorToRed(){
        color = "red";
    }


    private int getLength(){
        return left + top + right + bottom;
    }

    public int getPublicLength(){
        return getLength();
    }


    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getTop() {
        return top;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public int getBottom() {
        return bottom;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setLeft(int left) {
        this.left = left;
    }

    @Override
    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
