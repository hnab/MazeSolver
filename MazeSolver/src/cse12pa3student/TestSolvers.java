package cse12pa3student;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if (expected == null) {
			assertNull(s);
		} else {
			String actualStr = formatMaze(startMaze.showSolution());
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s : arr)
			result += "\n" + s;
		return (result + "\n");
	}

	/* Worklist Tests */

	@Test
	public void testStackWorklist() {
		Square s1 = new Square(0, 0, false);
		Square s2 = new Square(1, 0, false);
		Square s3 = new Square(1, 1, false);
		SearchWorklist swl = new StackWorklist();

		swl.add(s1);
		swl.add(s2);
		assertEquals(false, swl.isEmpty());

		swl.remove();
		swl.remove();
		assertEquals(true, swl.isEmpty());

		// Ensure stack behavior
		swl.add(s1);
		swl.add(s2);
		swl.add(s3);
		assertEquals(s3, swl.remove());
	}

	@Test
	public void testQueueWorklist() {
		Square s1 = new Square(0, 0, false);
		Square s2 = new Square(1, 0, false);
		Square s3 = new Square(1, 1, false);
		SearchWorklist qwl = new QueueWorklist();

		qwl.add(s1);
		qwl.add(s2);
		assertEquals(false, qwl.isEmpty());

		qwl.remove();
		qwl.remove();
		assertEquals(true, qwl.isEmpty());

		// Ensure queue behavior
		qwl.add(s1);
		qwl.add(s2);
		qwl.add(s3);
		assertEquals(s1, qwl.remove());
	}

	@Test
	public void testClassExample() {
		Maze m = new Maze(new String[] { "#_#_", "____", "_##S", "F___" });
		String[] stackExpected = { "#_#_", "****", "*##S", "F___" };
		checkMaze(new StackWorklist(), m, stackExpected);

	}

	@Test
	public void testFailingOrder() {
		String[] expected = { "#_#_", "****", "*##S", "F___" };
		String[] actualAndWrong = { "#_#_", "****", "*##S", "F___" };
		assertEquals(formatMaze(expected), formatMaze(actualAndWrong));
	}

	@Test
	public void test1() {

		Maze m = new Maze(new String[] { "#_#_", "_##_", "_##S", "F___" });
		String[] stackExpected = { "#_#_", "_##_", "_##S", "F***" };

		checkMaze(new QueueWorklist(), m, stackExpected);

	}

	@Test
	public void test2() {
		Maze m = new Maze(new String[] { "####", "#___", "_##S", "F__#" });
		String[] stackExpected = null;
		checkMaze(new QueueWorklist(), m, stackExpected);
	}

	@Test
	public void test3() {
		Maze m = new Maze(new String[] { "_____", "_##__", "_##S_", "F_#__", "###__" });
		String[] stackExpected = { "****_", "*##*_", "*##S_", "F_#__", "###__" };
		checkMaze(new QueueWorklist(), m, stackExpected);

	}

	@Test
	public void test4() {
		Maze m = new Maze(new String[] { "#_#__", "_____", "_#_S_", "__##_", "F__#_" });
		String[] stackExpected = { "#_#__", "****_", "*#_S_", "*_##_", "F__#_" };
		checkMaze(new StackWorklist(), m, stackExpected);
	}

	@Test
	public void test5() {

		Maze m = new Maze(new String[] { "#____", "__#__", "_##S_", "__##_", "F____" });
		String[] stackExpected = { "#***_", "**#*_", "*##S_", "*_##_", "F____" };

		checkMaze(new StackWorklist(), m, stackExpected);
	}

	@Test
	public void test6() {
		Maze m = new Maze(new String[] { "#____", "__#__", "_##S_", "__##_", "F____" });
		String[] stackExpected = { "#____", "__#__", "_##S*", "__##*", "F****" };

		checkMaze(new QueueWorklist(), m, stackExpected);
	}

	@Test
	public void testClassExample2() {

		Maze m = new Maze(new String[] { "#F#_", "____", "_#S_", "____" });
		String[] stackExpected = { "#F#_", "_**_", "_#S_", "____" };
		checkMaze(new StackWorklist(), m, stackExpected);

	}

	@Test
	public void test7() {
		Maze m = new Maze(new String[] { "#______", "__##___", "_F#_#__", "#_#S_##", "#_##__#", "#____##"

		});
		String[] stackExpected = { "#______", "__##___", "_F#_#__", "#*#S*##", "#*##*_#", "#****##"

		};

		checkMaze(new QueueWorklist(), m, stackExpected);
	}

	@Test
	public void test8() {

		Maze m = new Maze(new String[] { "#______", "__##___", "_F#_#__", "#_#S_##", "#_##__#", "#____##"

		});
		String[] stackExpected = { "#______", "__##___", "_F#_#__", "#*#S*##", "#*##*_#", "#****##"

		};
		checkMaze(new StackWorklist(), m, stackExpected);
	}

}
