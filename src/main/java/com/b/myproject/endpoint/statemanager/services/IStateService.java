package com.b.myproject.endpoint.statemanager.services;

import com.b.myproject.endpoint.statemanager.StateEntity;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public interface IStateService {
    void sendState(StateEntity entity);

    Observable<StateEntity> stateAsObs();
}
