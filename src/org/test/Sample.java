package org.test;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\00 GIT Sample Project\\driver\\chromedriver.exe");		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		WebElement txtSearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		txtSearch.sendKeys("iPhone 11", Keys.ENTER);
		
		LinkedHashMap<String, Integer> mp =new LinkedHashMap<>();
		
		List<WebElement> phones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		for (WebElement p : phones) {
			
			String text = p.getText();
			
//			System.out.println(text);
			
			if (mp.containsKey(text)) {
				
				Integer count = mp.get(text);
				mp.put(text, count + 1);
			} else {
				mp.put(text, 1);
			}
		}
		
		Set<Entry<String, Integer>> entries = mp.entrySet();
		for (Entry<String, Integer> entry : entries) {
			
			Integer value = entry.getValue();
			
			if (value > 1) {
				
				String key = entry.getKey();
				System.out.println(key);
				
				System.out.println("Duplicated Product : " + key);
				System.out.println("Duplicated Count : " + value);
				
			}			
		}
	}

}