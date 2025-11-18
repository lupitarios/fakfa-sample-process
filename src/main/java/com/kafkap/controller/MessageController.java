package com.kafkap.controller;

import com.kafkap.producer.MessageProducer;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message){
        messageProducer.sendMessage(message);
        return new ResponseEntity<>("Message sent: " + message, HttpStatusCode.valueOf(200));
    }
}
