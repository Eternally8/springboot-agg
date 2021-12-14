package com.robben.event;

import com.robben.model.UserVoEntity;
import org.springframework.context.ApplicationEvent;

public class ContentSmartEvent extends ApplicationEvent {

    private UserVoEntity userVoEntity;

    public ContentSmartEvent(Object source, UserVoEntity userVoEntity) {
        super(source);
        this.userVoEntity = userVoEntity;
    }

    public UserVoEntity getUserVo() {
        return userVoEntity;
    }

    public void setUserVo(UserVoEntity userVoEntity) {
        this.userVoEntity = userVoEntity;
    }
}
