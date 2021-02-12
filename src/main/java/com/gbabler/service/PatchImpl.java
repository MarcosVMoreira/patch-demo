package com.gbabler.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Slf4j
@AllArgsConstructor
public class PatchImpl<T,V> {

    private final T source;
    private final V destination;

    public <U> PatchImpl<T,V> updateIfPresent(Function<T,U> getter, BiConsumer<V,U> setter) {
        Optional.ofNullable(getter.apply(source))
                .ifPresent(fieldValue -> setter.accept(destination, fieldValue));
        return this;
    }
}
