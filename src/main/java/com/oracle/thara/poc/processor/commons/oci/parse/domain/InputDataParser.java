package com.oracle.thara.poc.processor.commons.oci.parse.domain;

import java.util.List;

public interface InputDataParser<T> {
	List<ParsedData> parse(InputData<T> inputData);
}
