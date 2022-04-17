package com.oracle.thara.poc.processor.commons.oci.parse;

import java.util.List;

public interface InputDataParser<T> {

    List<ParsedData> parse(InputData<T> inputData);
  
}
