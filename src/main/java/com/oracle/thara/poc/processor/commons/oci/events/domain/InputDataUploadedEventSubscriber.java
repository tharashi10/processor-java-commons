package com.oracle.thara.poc.processor.commons.oci.events.domain;

public interface InputDataUploadedEventSubscriber {
    void onUploaded(InputDataUploadedEvent event);
}
