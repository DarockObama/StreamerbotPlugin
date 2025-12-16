package com.streamerbot;

import lombok.Getter;
import java.util.Map;
import java.util.Collections;

@Getter
public class DoActionRequest {
    private final String id;
    private final String name;
    private final Map<String, Object> args;

    public DoActionRequest(String id, String name, Map<String, Object> args) {
        this.id = id;
        this.name = name;
        this.args = (args != null) ? Collections.unmodifiableMap(args) : Collections.emptyMap();
    }

    public DoActionRequest(String id, String name) {
        this(id, name, Collections.emptyMap());
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        // Action object
        jsonBuilder.append("\"action\": {");
        jsonBuilder.append("\"id\": \"").append(id).append("\", ");
        jsonBuilder.append("\"name\": \"").append(name).append("\"");
        jsonBuilder.append("}, ");

        // Args object
        jsonBuilder.append("\"args\": {");
        boolean first = true;
        for (Map.Entry<String, Object> entry : args.entrySet()) {
            if (!first) {
                jsonBuilder.append(", ");
            }
            first = false;

            jsonBuilder.append("\"").append(entry.getKey().replace("\"", "\\\"")).append("\": ");
            if (entry.getValue() instanceof String) {
                jsonBuilder.append("\"").append(entry.getValue()).append("\"");
            } else {
                jsonBuilder.append(entry.getValue());
            }
        }
        jsonBuilder.append("}");

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}