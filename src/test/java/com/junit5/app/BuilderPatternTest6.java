package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit5.app.dto.Multiverse;

public class BuilderPatternTest6 {
	private static Logger logger=Logger.getLogger(BuilderPatternTest6.class.getName());

	private Multiverse multiverse;
	
	@BeforeEach
	void init(){
		multiverse=new Multiverse.MultiverseBuilder()
								 .makeUUId(UUID.randomUUID())
				                 .createUniverse("Earth")
				                 .setUniverseType("Big Bang")
				                 .isHumanExists(true)
				                 .build();	
		}
	
	@Test
	@DisplayName("Builder Testing")
	void TestBuilder() {
		assertEquals("Big Bang", multiverse.getUniverseType(), "test failed");
		logger.info("Builder testing");
	}
	
	
	
}
