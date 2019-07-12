package co.AssessmentsQuestions.question2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActivityOnWWPage {

	WebDriver driver;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.get("https://www.weightwatchers.com/us/");
		} catch (Exception e) {
			e.printStackTrace();
		}

		performOpeartion();
	}

	public void performOpeartion() {
		//--Step 2--//

		try {
			String actualPageTitle = driver.getTitle();

			String expectedPageTile = "WW (Weight Watchers): Weight Loss & Wellness Help";

			if (actualPageTitle.equalsIgnoreCase(expectedPageTile)) {
				System.out.println("Correct First Page Title : " + actualPageTitle);
			} else {
				System.out.println("Incorrect First Page Title");
			}

			// --Steps 3 and 4 Step--//

			driver.findElement(By.id("ela-menu-visitor-desktop-supplementa_find-a-studio")).click();

			String actualSecondTitle = driver.getTitle();

			String expectdSecondTitle = "Find WW Studios & Meetings Near You | WW USA";
			

			if (actualSecondTitle.equalsIgnoreCase(expectdSecondTitle)) {
				System.out.println("Correct Second Page Title : " + actualSecondTitle);
			} else {
				System.out.println("incorrect Second Page Title ");
			}

			//--Step 5--//

			driver.findElement(By.id("meetingSearch")).sendKeys("10011");
			driver.findElement(By.cssSelector("button[type='button']")).click();

			Thread.sleep(3000);

			//-- Step6 --//

			String firstResultTitle = driver.findElement(By.cssSelector("span[ng-if='!linkName']")).getText();
			String firstResultDistance = driver.findElement(By.className("location__distance")).getText();
			System.out.println(firstResultTitle + " and " + firstResultDistance);
			Thread.sleep(3000);

			//--Step 7--//

			driver.findElement(By.className("meeting-location")).click();

			String displaySearchTitle = driver.findElement(By.cssSelector("span[ng-if='!linkName']")).getText();

			if (firstResultTitle.equalsIgnoreCase(displaySearchTitle)) {
				System.out.println("Search result title match");
			} else {
				System.out.println("Search result title does not match");
			}

			
			//--Step 9--//
			
			String dayName = driver.findElement(By.className("hours-list-item-day")).getText();
			
			String dayTime = driver.findElement(By.className("hours-list-item-hours")).getText();
			
			System.out.println("Todays opeartion :" + dayName + " and time is " + dayTime);
			
			closeBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) {
		ActivityOnWWPage myObj = new ActivityOnWWPage();
		myObj.invokeBrowser();

	}

}
