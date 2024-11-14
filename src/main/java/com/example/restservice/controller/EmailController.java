package com.example.restservice.controller;


import com.example.restservice.domain.NewEmailRequest;
import com.example.restservice.domain.SimpleEmail;
import com.example.restservice.util.SerializeUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email")
public class EmailController {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {this.rabbitTemplate = rabbitTemplate;}

    @PostMapping("direct")
    public ResponseEntity<String> produceDirect(@RequestBody NewEmailRequest request,
                                                @RequestParam String routingKey) {
        SimpleEmail newEmail = SimpleEmail.builder()
                .fromAddress(request.getFromAddress())
                .toAddress(request.getToAddress())
                .content(request.getContent())
                .build();

        String jsonMessage = SerializeUtil.serialize(newEmail);

        rabbitTemplate.convertAndSend("emailExchange", routingKey, jsonMessage);
        return ResponseEntity.ok("Message Sent");
    }

}
