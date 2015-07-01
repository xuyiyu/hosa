package com.mexp.web.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath:/spring/applicationContext*.xml"})
public class BaseServiceTestCase extends AbstractTransactionalJUnit4SpringContextTests{

	
	
}
