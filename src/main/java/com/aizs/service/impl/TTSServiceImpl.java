package com.aizs.service.impl;

import com.aizs.entity.TextToSpeechRequest;
import com.aizs.service.TTSService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TTSServiceImpl implements TTSService {

    private static final Logger logger = LoggerFactory.getLogger(TTSServiceImpl.class);

    @Value("${tts.script.path}") // 通过配置文件读取 Python 脚本路径
    private String pythonScriptPath;

    @Override
    public String synthesizeSpeech(TextToSpeechRequest request) {
        try {
            logger.info("Starting speech synthesis with text: {}, voice: {}, speed: {}, pitch: {}",
                    request.getText(), request.getVoice(), request.getSpeed(), request.getPitch());

            // 调用 Python 脚本进行语音合成
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "python",
                    pythonScriptPath,
                    request.getText(),
                    request.getVoice(),
                    String.valueOf(request.getSpeed()),
                    String.valueOf(request.getPitch())
            );

            processBuilder.inheritIO(); // 启动 Python 进程
            Process process = processBuilder.start();
            int exitCode = process.waitFor(); // 等待进程执行完成
            if (exitCode == 0) {
                logger.info("Synthesis completed successfully.");
                return "Synthesis started successfully.";
            } else {
                logger.error("Error during speech synthesis. Exit code: " + exitCode);
                return "Error during speech synthesis.";
            }
        } catch (Exception e) {
            logger.error("Error starting synthesis: {}", e.getMessage(), e);
            return "Error starting synthesis.";
        }
    }
}
