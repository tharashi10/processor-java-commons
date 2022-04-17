package com.oracle.thara.poc.processor.commons.oci.parse;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class InputData<T> {

  @NonNull
  private Date createdTime;

  @NonNull
  private T data;

}
