package org.example.time.client;

import org.junit.jupiter.api.Test;

class TimeClientTest {

	@Test
	void test() throws InterruptedException {
		TimeClient timeClient = new TimeClient("127.0.0.1", 8080);
		timeClient.run();
	}
}
