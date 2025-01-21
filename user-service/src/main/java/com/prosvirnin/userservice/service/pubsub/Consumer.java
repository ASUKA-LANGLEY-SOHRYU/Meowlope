package com.prosvirnin.userservice.service.pubsub;

public interface Consumer<T> {
    void consume(T t);
}
