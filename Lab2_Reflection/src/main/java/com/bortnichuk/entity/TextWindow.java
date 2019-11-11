package com.bortnichuk.entity;

import com.bortnichuk.annotation.MyAnnotation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class TextWindow extends Window {

    String text;
    String textColor;

    @MyAnnotation
    public void changeText(String newText){
        text = newText;
    }

}
