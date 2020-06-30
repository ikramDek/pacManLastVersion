package tests.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import main.Main;
import view.GameFrame;

public class TestIkramMenu {
	private static int DEFAULT_FPS = 50;
	private static GameFrame globalFrame;
	private static Robot robot ;

	public static void main(String[] args) {

		int fps = DEFAULT_FPS;

		int period = (int) 1000.0/fps;
		System.out.println("fps: " + fps + "; period: " + period + " ms");

		globalFrame = new GameFrame(period); 
		// ms
		try {
			robot= new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		TestSounds();
	}

	public static GameFrame getGlobalFrame() {
		return globalFrame;
	}

	public static void setGlobalFrame(GameFrame globalFrame) {
		Main.globalFrame = globalFrame;
	}
	public static void TestSounds() {
		robot.delay(1000);
		robot.setAutoDelay(500);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	


}
