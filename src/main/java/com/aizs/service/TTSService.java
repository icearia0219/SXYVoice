package com.aizs.service;

import com.aizs.entity.TextToSpeechRequest;

public interface TTSService {
    String synthesizeSpeech(TextToSpeechRequest request);
}
