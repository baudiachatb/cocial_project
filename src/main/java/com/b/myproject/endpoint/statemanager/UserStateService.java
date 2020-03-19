package com.b.myproject.endpoint.statemanager;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserStateService {
    private static Subject<String> updatedUser$ = PublishSubject.create();
    public void sendUpdateUser(String idUser){
        updatedUser$.onNext(idUser);
    }
    public Observable<String> updateUserAsObs(){
        return updatedUser$;
    }
}
