package org.example.time.server;

import org.example.discard.server.DiscardServer;
import org.junit.jupiter.api.Test;

class TimeServerTest {
	@Test
	void test() throws InterruptedException {
		DiscardServer discardServer = new DiscardServer(8080, new TimeServerHandler());
		discardServer.run(null);
	}
}
