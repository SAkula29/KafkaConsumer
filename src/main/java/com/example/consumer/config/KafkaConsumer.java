package com.example.consumer.config;

import com.example.consumer.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="test12",groupId = "test23")
    public void consume(Message message){
        logger.info("message:"+ message);

    }

}
