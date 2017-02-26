package net.me.test;

import org.testng.annotations.Test;

import net.me.dev.utils.Task;
import net.me.dev.utils.TaskScheduler;

public class TestCase {
	@Test
	public void testScheduler() {
		Task task = new Task();
		TaskScheduler ts = new TaskScheduler(task);
		ts.turnOn();
	}
}
