package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;


	public  void browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}

		else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

	}


	public static void javaScriptex(String name, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (name.equalsIgnoreCase("Scroll up")) {
			js.executeScript("window.scrollBy(0, -1500)");
		}

		else if (name.equalsIgnoreCase("Scroll down")) {
			js.executeScript("window.scrollBy(0, 2500)");

		}

		else if (name.equalsIgnoreCase("move desired position")) {
			js.executeScript("arguments[0].scrollIntoView()", element);
		}

		else if (name.equalsIgnoreCase("Scroll top")) {
			js.executeScript("window.scrollTo(0,0)");
		}
		else if (name.equalsIgnoreCase("Scroll bottom")) {
			js.executeAsyncScript("window.scroll(0,document.body.scrollHeight)");
		}

		else if (name.equalsIgnoreCase("click position")) {
			js.executeScript("arguments[0].click()", element);
		}
	}

	public static void Sleep() throws InterruptedException {
		

		Thread.sleep(2000);
	}


	public static void selectMethods(WebElement element, String name,String str, int index) {
		Select s = new Select(element);

		if (name.equalsIgnoreCase("index")) {
			s.selectByIndex(index);
		}
		else if (name.equalsIgnoreCase("text")) {
			s.selectByVisibleText(str);
		} 
		else if (name.equalsIgnoreCase("value")) {
			s.selectByValue(str);
		}

	}


	public static void windowshandling() {
		Set<String> winhandles = driver.getWindowHandles();
		List<String> allWin = new LinkedList<>();
		allWin.addAll(winhandles);	

		driver.switchTo().window(allWin.get(1));

	}

	public static void selectbyIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public static void selectbyvalu(WebElement element,String valu) {
		Select s = new Select(element);
		s.selectByValue(valu);
	}
	public static void selectbyvisibletext(WebElement element,String tex) {
		Select s = new Select(element);
		s.selectByVisibleText(tex);
	}




	public static void thread() throws InterruptedException {
		Thread.sleep(2000);
	}

	public static void actionsMethods(WebElement element, String value) {

		Actions ac = new Actions(driver);
		if (value.equalsIgnoreCase("click")) {
			ac.click(element).build().perform();
		}

		else if (value.equalsIgnoreCase("doubleclick")) {
			ac.doubleClick(element).build().perform();
		} 
		else if (value.equalsIgnoreCase("contextclick")) {
			ac.contextClick(element).build().perform();

		}
		else if (value.equalsIgnoreCase("movetoelement")) {
			ac.moveToElement(element).build().perform();
		}

	}



	public  void urlLaunch(String url) {

		driver.get(url);

	}

	public static void navigationRefresh() {
		driver.navigate().refresh();

	}
	public static void navigationback() {
		driver.navigate().back();

	}



	public static void maximize () {
		driver.manage().window().maximize();
	}

	public  void sendText(WebElement keys,String user) {

		keys.sendKeys(user);

	}

	public  void buttonClick(WebElement button) {
		button.click();

	}

	public void screenCapture(String capture) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File a = ts.getScreenshotAs(OutputType.FILE);
		File b = new File("C:\\Users\\Lenovo\\Desktop\\Screenshot\\" + capture + ".png");
		FileUtils.copyFile(a, b);


	}


	public  void Robot(int value ) throws AWTException {
		Robot r = new Robot();
		r.keyPress(value);
		r.keyRelease(value);
	}



	public void alert1(String type) {
		Alert alert = driver.switchTo().alert();

		switch (type) {
		case "Accept":
			alert.accept();
			break;

		case "Dismiss":
			alert.dismiss();
			break;

		default:
			break;
		}
	}

	public static void alertMethods(String alertt) {

		Alert a = driver.switchTo().alert();
		if (alertt.equalsIgnoreCase("Accept")) {
			a.accept();
		}
		else if (alertt.equalsIgnoreCase("Dismiss")) {
			a.dismiss();
		}
	}

	public static void frame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void winHandles() {

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handles : windowHandles) {
			driver.switchTo().window(handles);
		}
	}

	public static void switchWindows(int index) {

		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> list = new LinkedList<String>();
		list.addAll(allWindowsID);
		// To get Particular values
		String childWindowsID = list.get(index);
		// To Switch To Windows
		driver.switchTo().window(childWindowsID);

	}

//	public static void WindowSwitchingall(String name) {
//		Set<String> windowHandles = driver.getWindowHandles();
//
//		for (String ab : windowHandles) {
//			driver.switchTo().window(ab);
//			String title = driver.getTitle();
//			System.out.println(title);
//		}
//
//   
//		
//	}
//	
//	public void WincloseAlltab(String name) {
//		String parentwin = driver.getWindowHandle();
//
//		Set<String> windowHandles = driver.getWindowHandles();
//
//		for (String allwindows : windowHandles) {
//			if (!allwindows.equals(parentwin)) {
//				driver.switchTo().window(allwindows);
//				driver.close();
//			}
//
//
//		}
//	}
//
//	public static void WinMoveSpecifictab(String name) {
//		Set<String> windowHandles = driver.getWindowHandles();
//
//		for (String ab : windowHandles) {
//			driver.switchTo().window(ab);
//			String exp = "Amazon.in Bestsellers: The most popular items on Amazon";
//			String Act = driver.getTitle();
//
//			if (exp.equals(Act)) {
//				break;
//			}
//
//		}
	

	public static void win (int index) {

		Set<String> windowHandles = driver.getWindowHandles();
		List<String>li = new LinkedList<String>();
		li.addAll(windowHandles);
		String child = li.get(index);
		driver.switchTo().window(child);

	}

	public static void waits (int index) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}







	public static String getWindowsID(int index) {

		Set<String> allWindowsID = driver.getWindowHandles();
		List<String> list = new LinkedList<String>();
		list.addAll(allWindowsID);
		// To get Particular values
		String childWindowsID = list.get(index);
		return childWindowsID;
	}
	public void switchtoWindows(String childWindowsID) {

		// To Switch To Windows
		driver.switchTo().window(childWindowsID);
	}




	public void clear(WebElement delete) {

		delete.clear();

	}



	public String readExcel(int rownum,int cellnum) throws IOException {

		File f = new File("D:\\Saucedemo.xlsx"); 
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");

		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		org.apache.poi.ss.usermodel.CellType cellType = cell.getCellType();		

		String value = null;
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;


		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				sdf.format(dateCellValue);
			}


			else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				value = valueOf.toString();
			}
			break;


		default:
			System.out.println("undefined format");
			break;
		}

		return value;
	}



	public static void windowhandles() {

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		for (String a : windowHandles) {
			System.out.println(a);
			driver.switchTo().window(a);
			String title = driver.getTitle();
			System.out.println(title);

		}
	}

	public static void quitbrowser() {
		driver.quit();
	}


	public static void implicitwait(int duration) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}


	public static void clickk(WebElement clickkk) {
		clickkk.click();

	}












}
