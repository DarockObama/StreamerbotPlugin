package com.streamerbot.messaging;

import lombok.Getter;

@Getter
public class DoActionRequest {
    protected final Action action;
    // private final Map<String, Object> args;

    public DoActionRequest(Action action /*, Map<String, Object> args */) {
        this.action = action;
        //this.args = (args != null) ? Collections.unmodifiableMap(args) : Collections.emptyMap();
    }

    public DoActionRequest(String name/*,  Map<String, Object> args*/) {
        this(new Action(name) /*, args*/);
    }

    @Getter
    public static class Action {
        private final String name;

        public Action(String name) {
            this.name = name;
        }
    }
}
