package com.Rabbitmq.Productor;

import org.springframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerController {

    private static final Logger log = LoggerFactory.getLogger(ListenerController.class);

    @RabbitListener(queues = ProductorApplication.DEFAULT_PARSING_QUEUE)
    public void readDefaultMessage(final Message message) {
        log.info("Received Message", message.toString());
    }
}
