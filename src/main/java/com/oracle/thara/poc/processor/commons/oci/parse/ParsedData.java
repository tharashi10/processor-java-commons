package com.oracle.thara.poc.processor.commons.oci.parse;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class ParsedData {

  public static class StringValueMapper implements Function<String, Object> {

    // TODO JSON データ型への変換を検討
    @Override
    public Object apply(String value) {
    	ObjectMapper objectMappper = new ObjectMapper();
    	try {
    		Map<String, Object> inputMap = new HashMap<String, Object>();
    		inputMap = objectMappper.readValue(value, new TypeReference<HashMap<String, Object>>(){});

    		Map<String, Object> convertedMap = inputMap;

    		// String to (null, int, float, boolean)
    		inputMap.forEach((k,v)->{
    			if(v.toString().isEmpty()){
    				convertedMap.put(k, null);
    		    }else if(v.toString().matches("[+-]?\\d*")){
    		    	convertedMap.put(k, Integer.parseInt(convertedMap.get(k).toString()));
    		    }else if(v.toString().matches("[+-]?\\d*(\\.\\d+)?")){
    		    	convertedMap.put(k, Float.parseFloat(convertedMap.get(k).toString()));
    		    }else if(v.toString().matches("^(?i)(true|false)$")){
    		    	convertedMap.put(k, Boolean.parseBoolean(convertedMap.get(k).toString()));
    		    }
    		});
    		ObjectMapper mapper = new ObjectMapper();
    		String jsonText = null;
    		jsonText = mapper.writeValueAsString(convertedMap);
    		return jsonText;
		} catch (JsonMappingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return value;
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return value;
		}
    }
  }

  private static Function<String, Object> stringValueMapper() {
    return new StringValueMapper();
  }

  @NonNull
  private final LocalDateTime createdTime;

  @NonNull
  private final Optional<LocalDateTime> time;

  @NonNull
  @Getter
  private final Map<String, Object> value;

  public ParsedData(Date createdTime, Optional<LocalDateTime> time,
      Set<Map.Entry<String, String>> value) {
    this(createdTime, time, value, stringValueMapper());
  }

  public ParsedData(Date createdTime, Optional<LocalDateTime> time,
      Set<Map.Entry<String, String>> value, Function<String, Object> stringValueMapper) {
    this(createdTime, time,
        value.stream()
            .map(entry -> Map.entry(entry.getKey(), stringValueMapper.apply(entry.getValue())))
            .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue)));
  }

  // TODO Date から LocalDateTime への変換が想定通りかチェック
  public ParsedData(Date createdTime, Optional<LocalDateTime> time, Map<String, Object> value) {
    this(LocalDateTime.ofInstant(createdTime.toInstant(), ZoneId.of("Asia/Tokyo")), time, value);
  }

  // TODO 時刻の取得ロジックをテスト
  public LocalDateTime getTime() {
    return time.orElse(createdTime);
  }

}

