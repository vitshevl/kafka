package com.example.kafka.service;

import com.example.kafka.dto.MessageDto;

public interface KafkaPoCService {

    void sendMessageToValidTopic(MessageDto msg);
    void sendMessageToBrokenTopic(MessageDto msg);

}
