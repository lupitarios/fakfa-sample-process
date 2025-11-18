package com.kafkap.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "sample-topic", groupId = "sample-topic")
    public void listen(String message){
        System.out.println("Consumed Message" + message);
    }
}
