package org.example.discard.server;

import org.junit.jupiter.api.Test;

public class DiscardServerTest {

	@Test
	void test() throws InterruptedException {
		DiscardServerRun discardServerRun = new DiscardServerRun();
		discardServerRun.run(null);
	}
}
