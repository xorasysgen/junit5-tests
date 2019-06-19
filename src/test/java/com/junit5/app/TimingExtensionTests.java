package com.junit5.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.junit5.app.ext.TimingExtension;

@DisplayName("Timing Extension")
@ExtendWith(TimingExtension.class)
public class TimingExtensionTests {

	@Test
    void sleep200ms() throws Exception {
        Thread.sleep(200);
    }

    @Test
    void sleep50ms() throws Exception {
        Thread.sleep(50);
    }
}
