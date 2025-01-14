package com.aizs.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TextToSpeechRequest {
    // Getters 和 Setters
    private String text; // 要合成的文本
    private String voice; // 语音人声
    private int speed;    // 语速
    private int pitch;    // 音调

}
