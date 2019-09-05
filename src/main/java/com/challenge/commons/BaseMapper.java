package com.challenge.commons;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class BaseMapper<D, M> implements Mapper<D, M> {

    @Override
    public List<D> toDtos(List<M> models) {
        final List<D> result = Lists.newArrayListWithCapacity(models.size());
        models.forEach(entity -> result.add(toDto(entity)));
        return result;
    }

    @Override
    public List<M> toModels(List<D> dtos) {
        final List<M> result = Lists.newArrayListWithCapacity(dtos.size());
        dtos.forEach(d -> result.add(toModel(d)));
        return result;
    }
}
