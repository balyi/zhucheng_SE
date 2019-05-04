package edu.taihu.logistics.service;

public interface Function<E, T> {

    public T execute(E e);

}
