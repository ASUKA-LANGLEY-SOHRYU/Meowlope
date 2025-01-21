package com.prosvirnin.userservice.service.pubsub.rabbitmq;

import com.prosvirnin.userservice.model.dto.UserInfo;
import com.prosvirnin.userservice.service.pubsub.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoConsumer implements Consumer<UserInfo> {
    @Override
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "userInfoQueue", durable = "true"),
            exchange = @Exchange(value = "${service.rabbitmq.exchange.user-info}", type = "direct", durable = "true"),
            key = "${service.rabbitmq.routing-key.user-info}"
    ))
    public void consume(UserInfo userInfo) {
        log.info("Received user info: " + userInfo);
    }
}
