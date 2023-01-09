package org.example.discard.server;

public class DiscardServerRun {

	public void run(String[] args) throws InterruptedException {
		int port = 8080;
		if (args != null && args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		new DiscardServer(port).run();
	}
}
