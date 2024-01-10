package com.example.kafka.controller;


import com.example.kafka.dto.MessageDto;
import com.example.kafka.service.KafkaPoCService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final KafkaPoCService kafkaPoCService;

    @PostMapping(value = "/valid-topic", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendToValid(@RequestBody MessageDto request) {

       kafkaPoCService.sendMessageToValidTopic(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/broken-topic", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendToBroken(@RequestBody MessageDto request) {

        kafkaPoCService.sendMessageToBrokenTopic(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
