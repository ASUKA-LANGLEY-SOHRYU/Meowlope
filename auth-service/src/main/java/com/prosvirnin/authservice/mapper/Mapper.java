package com.prosvirnin.authservice.mapper;

public interface Mapper<T, U> {
    U map(T t);
}
