package com.streamerbot.messaging;
import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class ActionRequest {
    private final DoActionRequest.Action action;
    private final JsonObject args;

}
