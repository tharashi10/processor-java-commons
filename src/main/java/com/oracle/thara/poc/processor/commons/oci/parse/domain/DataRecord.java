package com.oracle.thara.poc.processor.commons.oci.parse.domain;

import java.time.LocalDateTime;
import java.util.Map;

import com.oracle.thara.poc.processor.commons.oci.events.domain.InputDataUploadedEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class DataRecord {

  @NonNull
  private LocalDateTime time;

  @NonNull
  private String dataOwner;

  @NonNull
  private String dataType;

  @NonNull
  private String dataSource;

  @NonNull
  private Map<String, Object> value;

  public DataRecord(InputDataUploadedEvent event, ParsedData parsedData) {
    this(parsedData.getTime(), event.getDataOwner(), event.getDataType(), event.getDataSource(),
        parsedData.getValue());
  }

}
