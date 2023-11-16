package com.Rabbitmq.Productor;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class SenderController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(SenderController.class);

    private final RabbitTemplate rabbitTemplate;

    public SenderController(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 2000L)
    public void sendData() {
        MessageController tip = new MessageController("Transfer received and sent successfully.", new Random().nextInt(100), false, LocalDateTime.now() );
        rabbitTemplate.convertAndSend(ProductorApplication.EXCHANGE_NAME, ProductorApplication.ROUTING_KEY, tip);
        log.info("Sending Message...");
    }
}