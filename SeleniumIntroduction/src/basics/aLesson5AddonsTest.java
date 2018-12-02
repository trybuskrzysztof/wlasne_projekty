package basics;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class aLesson5AddonsTest {

	static FirefoxProfile firefoxprofile = new FirefoxProfile();
	
	public static void addAddons() {
		// TODO Auto-generated method stub
		File firebug_path = new File("C:\\Program Files\\Mozilla Firefox\\firebug-2.0.19-fx.xpi");
		File firepath_path = new File("C:\\Program Files\\Mozilla Firefox\\firepath-0.9.7.1-fx.xpi");
		
		
		firefoxprofile.addExtension(firebug_path);
		firefoxprofile.addExtension(firepath_path);

	}

}
