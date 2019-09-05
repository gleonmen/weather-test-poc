package com.challenge.commons;

import java.util.List;

public interface Mapper<D, M> {
    D toDto(M model);
    List<D> toDtos(List<M> models);
    M toModel(D dto);
    List<M> toModels(List<D> dtos);
}
