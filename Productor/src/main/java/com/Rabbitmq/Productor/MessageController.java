package com.Rabbitmq.Productor;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MessageController implements Serializable {

    private final String information;
    private final int intensity;
    private final boolean secret;
    private final LocalDateTime datetime;

    public MessageController(final String information, final int intensity, final boolean secret, final LocalDateTime datetime){
        this.information = information;
        this.intensity = intensity;
        this.secret = secret;
        this.datetime = datetime;
    }

    public String getInformation() {
        return information;
    }

    public int getIntensity() {
        return intensity;
    }

    public boolean isSecret() {
        return secret;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    @Override
    public String toString() {
        return "MessageController{" +
                "information='" + information + '\'' +
                ", intensity=" + intensity +
                ", secret=" + secret +
                ", datetime=" + datetime +
                '}';
    }
}
