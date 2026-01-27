package streamerbot.messaging;
import lombok.Getter;

import java.util.Map;


@Getter
public class DoActionRequest {
    private final Action action;
    private final Map<String, Object> args;

    public DoActionRequest(Action action, Map<String, Object> args) {
        this.action = action;
        this.args = args;
    }

    public DoActionRequest(String name, Map<String, Object> args) {
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
