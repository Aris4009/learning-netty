package org.example.echo.server;

import org.example.discard.server.DiscardServer;

public class EchoServerRun {
	public void run(String[] args) throws InterruptedException {
		int port = 8080;
		if (args != null && args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		new DiscardServer(port, new EchoServerHandler()).run(null);
	}
}
