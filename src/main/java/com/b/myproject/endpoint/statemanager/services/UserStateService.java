package com.b.myproject.endpoint.statemanager.services;

import com.b.myproject.endpoint.statemanager.StateEntity;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserStateService implements IStateService {
    private final Subject<StateEntity> subject$ = PublishSubject.create();

    @Override
    public void sendState(StateEntity entity) {
        subject$.onNext(entity);
    }

    @Override
    public Observable<StateEntity> stateAsObs() {
        return subject$;
    }
}
