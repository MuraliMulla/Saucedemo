package com.reskill.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHaldle {
	
	public WebDriver windowHandle(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(0));
		return driver;
	}

	
}
