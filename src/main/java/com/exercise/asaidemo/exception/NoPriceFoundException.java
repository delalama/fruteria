package com.exercise.asaidemo.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "FRUIT SHOP")
public class NoPriceFoundException extends RuntimeException {
    public NoPriceFoundException(String s) {
        log.info(s);
    }
}
