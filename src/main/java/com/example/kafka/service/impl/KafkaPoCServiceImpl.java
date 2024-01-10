package com.example.kafka.service.impl;

import com.example.kafka.dto.MessageDto;
import com.example.kafka.service.KafkaPoCService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaPoCServiceImpl implements KafkaPoCService {

    private static final String VALID_TOPIC_NAME = "valid_topic";
    private static final String BROKEN_TOPIC_NAME = "broken_topic";


    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void sendMessageToValidTopic(MessageDto msg) {


        kafkaTemplate.send(VALID_TOPIC_NAME, msg.getMessage());

    }


    @Override
    public void sendMessageToBrokenTopic(MessageDto msg) {

        kafkaTemplate.send(BROKEN_TOPIC_NAME, msg.getMessage());
    }



    @KafkaListener(topics = VALID_TOPIC_NAME)
    public void listenValidTopic(String message) {
        log.info("Received Message valid: " + message);
    }


    @KafkaListener(topics = BROKEN_TOPIC_NAME)
    public void listenBrokenTopic(String message) {
        log.info("Received Message broken: " + message);
    }

}
