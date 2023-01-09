package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	@DisplayName("t1 测试")
	void t1() {
		String a = "hello test";
		Assertions.assertEquals(a, "hello test");
	}
}
