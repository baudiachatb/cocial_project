package com.b.myproject.endpoint.statemanager;

import com.b.myproject.endpoint.statemanager.services.UserStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StateComposite {
    public final UserStateService userStateService;
}
