package com.oracle.thara.poc.processor.commons.oci.parse.domain;

import java.util.List;

public interface DataRecordRepository {
	void saveAll(List<DataRecord> dataRecords);
}
