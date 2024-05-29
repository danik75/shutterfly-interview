package com.shutterfly.interview.mapper;

public interface Mapper<E, D> {
    D toDTO(E entity);
    E fromDTO(D dto);
}