package com.prosvirnin.authservice.service.pubsub;

public interface Publisher<T> {
    void publish(T t);
}
