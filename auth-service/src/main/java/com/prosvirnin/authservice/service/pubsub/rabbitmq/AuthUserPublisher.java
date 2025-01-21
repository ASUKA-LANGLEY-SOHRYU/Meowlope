package com.prosvirnin.authservice.service.pubsub.rabbitmq;

import com.prosvirnin.authservice.model.dto.UserInfo;
import com.prosvirnin.authservice.service.pubsub.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserPublisher implements Publisher<UserInfo> {

    @Value("${service.rabbitmq.exchange.user-info}")
    private String userInfoExchange;
    @Value("${service.rabbitmq.routing-key.user-info}")
    private String userInfoRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(UserInfo userInfo) {
        rabbitTemplate.convertAndSend(userInfoExchange, userInfoRoutingKey, userInfo);
    }
}
