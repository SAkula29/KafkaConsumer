package com.example.consumer.controller;



import com.example.consumer.models.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    Logger logger= LoggerFactory.getLogger(MainController.class)
    // Autowiring Kafka Template
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "test12";
    @GetMapping(path = "/",produces = MediaType.ALL_VALUE)
    public String ping(){
        return "consumer up and Running";
    }



    // Publish messages using the GetMapping
    @GetMapping("/publish/{id}")
    public String publishMessage(@PathVariable("id")
                                 final String id)
    {
logger.info("id:"+id);
        // Sending the message

        Message message = new Message();
        message.dstAddr="10.0.0.12";
        message.srcAddr="10.0.0.1";
        message.dstMac ="1a:01:14:8b:ee:29";
        message.inIf=37;
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json="";
        try {
             json = ow.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(TOPIC, json);

        return "Published Successfully";
    }
}
