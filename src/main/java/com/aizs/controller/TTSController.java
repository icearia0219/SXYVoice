package com.aizs.controller;

import com.aizs.entity.TextToSpeechRequest;
import com.aizs.service.TTSService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/tts")
public class TTSController {

    private static final Logger logger = LoggerFactory.getLogger(TTSController.class);

    @Autowired
    private TTSService ttsService;

    @PostMapping("/synthesize")
    public ResponseEntity<InputStreamResource> synthesizeSpeech(@RequestBody TextToSpeechRequest request) {
        logger.info("Received request: Text = {}, Voice = {}, Speed = {}, Pitch = {}",
                request.getText(), request.getVoice(), request.getSpeed(), request.getPitch());

        // 调用服务层的方法生成音频文件并获取文件路径
        String result = ttsService.synthesizeSpeech(request);

        // 如果合成成功，返回音频文件流
        if ("Synthesis started successfully.".equals(result)) {
            try {
                File audioFile = new File("D:/tts/demo.wav"); // 你生成的音频文件路径
                FileInputStream fileInputStream = new FileInputStream(audioFile);

                // 返回音频文件的流作为响应
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=demo.wav");
                headers.add(HttpHeaders.CONTENT_TYPE, "audio/wav"); // 使用字符串代替常量

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(new InputStreamResource(fileInputStream));

            } catch (IOException e) {
                logger.error("Error reading the audio file: {}", e.getMessage(), e);
                return ResponseEntity.status(500).body(null); // 返回服务器错误
            }
        } else {
            return ResponseEntity.status(500).body(null); // 返回服务器错误
        }
    }
}
