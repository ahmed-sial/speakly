package com.ahmedhassan.speakly;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class SpeaklyApplicationTests {

	@Test
	void verifyModules() {
		ApplicationModules.of(SpeaklyApplication.class).verify();
	}

}
