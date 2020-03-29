package com.b.myproject.endpoint.statemanager;

import com.b.myproject.entity.AbstractEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateEntity<T extends AbstractEntity> {
    public ActionType actionType;
    public T entity;
}
