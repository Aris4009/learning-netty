package org.example.echo.server;

import org.junit.jupiter.api.Test;

public class EchoServerTest {
	@Test
	void test() throws InterruptedException {
		EchoServerRun echoServerRun = new EchoServerRun();
		echoServerRun.run(null);
	}
}
