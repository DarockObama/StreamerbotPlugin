package com.streamerbot.messaging;
import com.streamerbot.dinkdata.DinkNotificationData;
import lombok.Getter;


@Getter
public class DoActionRequest {
    private final Action action;
    private final DinkNotificationData args;

    public DoActionRequest(Action action, DinkNotificationData args) {
        this.action = action;
        this.args = args;
    }

    public DoActionRequest(String name, DinkNotificationData args) {
        this(new Action(name), args);
    }

@Getter
    public static class Action {
        private final String name;

        public Action(String name) {
            this.name = name;
        }
    }
}
