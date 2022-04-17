package com.oracle.thara.poc.processor.commons.oci.parse.domain;

import java.util.Optional;

import com.oracle.thara.poc.processor.commons.oci.events.domain.InputDataUploadedEvent;

public interface InputDataRepository<T> {
	Optional<InputData<T>> findByUploadedEvent(InputDataUploadedEvent event);
}
