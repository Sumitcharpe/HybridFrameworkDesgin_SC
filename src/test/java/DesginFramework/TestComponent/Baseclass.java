package DesginFramework.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public WebDriver driver;
	Properties prop;

	@BeforeMethod
	public WebDriver intinilizeDriver() throws IOException {

		prop = new Properties();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir")
						+ File.separator + "src"
						+ File.separator + "main"
						+ File.separator + "java"
						+ File.separator + "DesignFramework"
						+ File.separator + "resources"
						+ File.separator + "Global.properties");

		prop.load(file);

		if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (prop.getProperty("browser").equals("edge")) {

			// code for edge
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		return driver;

	}

	// read file of Json

	public List<HashMap<String, String>> getJsonData(String filepath) throws IOException {

		String dataJsonPath = System.getProperty("user.dir")
				+ File.separator + "src"
				+ File.separator + "test"
				+ File.separator + "java"
				+ File.separator + "DesginFramework"
				+ File.separator + "TestData"
				+ File.separator + "data.json";

		File file = new File(dataJsonPath);
		if (!file.exists()) {
			throw new FileNotFoundException("File not found: " + dataJsonPath);
		}
		String jsonfile = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonfile,
				new TypeReference<List<HashMap<String, String>>>() {

				});

		return data;

	}

	public String captureScreenShot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		File DestinationFile = new File(System.getProperty("user.dir") + "//report//" + testCaseName + ".png");

		FileUtils.copyFile(sourceFile, DestinationFile);
		return System.getProperty("user dir") + "//report//" + testCaseName + ".png";

	}

	@AfterMethod

	public void closeBrowser() {
		driver.close();
	}

}
