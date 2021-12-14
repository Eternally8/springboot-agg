package com.robben.event;

import com.robben.model.UserVoEntity;
import org.springframework.context.ApplicationEvent;

public class ContentAnnoEvent extends ApplicationEvent {

    private UserVoEntity userVoEntity;

    public ContentAnnoEvent(Object source, UserVoEntity userVoEntity) {
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
