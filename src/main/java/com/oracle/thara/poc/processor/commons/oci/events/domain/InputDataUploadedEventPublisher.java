package com.oracle.thara.poc.processor.commons.oci.events.domain;

import java.util.function.Consumer;

public interface InputDataUploadedEventPublisher {
    void publish(String rawMessages, Consumer<InputDataUploadedEvent> subscriber);
}
