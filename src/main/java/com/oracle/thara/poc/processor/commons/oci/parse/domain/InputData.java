package com.oracle.thara.poc.processor.commons.oci.parse.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class InputData<T> {

  @NonNull
  private final Date createdTime;

  @NonNull
  private final T data;

}
