package com.example.consumer.config;

import com.example.consumer.models.Message;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class KafkaConsumerconfig {
        @Bean
        public ConsumerFactory<String, Message> consumerFactory()
        {

            // Creating a Map of string-object pairs
            Map<String, Object> config = new HashMap<>();

            // Adding the Configuration
            config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                    "127.0.0.1:9092");
            config.put(ConsumerConfig.GROUP_ID_CONFIG,
                    "test23");
            config.put(
                    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                    StringDeserializer.class);
            config.put(
                    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                    JsonDeserializer.class);

            // return message in JSON formate
            return new DefaultKafkaConsumerFactory<>(
                    config, new StringDeserializer(),
                    new JsonDeserializer<>(Message.class));
        }

        // Creating a Listener
        public ConcurrentKafkaListenerContainerFactory<String,
                Message> concurrentKafkaListenerContainerFactory()
        {
            ConcurrentKafkaListenerContainerFactory<String,
                    Message>
                    factory
                    = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }
    }

