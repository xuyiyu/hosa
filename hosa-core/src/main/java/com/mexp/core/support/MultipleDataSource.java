package com.mexp.core.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.mexp.core.support.context.DbContextHolder;

public class MultipleDataSource extends AbstractRoutingDataSource {

	private static final Logger log = LoggerFactory.getLogger(MultipleDataSource.class);
	@Override
	protected Object determineCurrentLookupKey() {
		log.debug("-----Lookup db type{}---", DbContextHolder.getDbType());
		return DbContextHolder.getDbType();
	}

}
