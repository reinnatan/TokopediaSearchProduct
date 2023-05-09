import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class TokopediaTest {
    private JavascriptExecutor js;

    @Test
    //method
    public void searchWatch () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.navigate().to("https://www.tokopedia.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@data-unify='Search']")).sendKeys("Jam Tangan");
        driver.findElement(By.xpath("//input[@data-unify='Search']")).sendKeys(Keys.RETURN);
        driver.findElement(By.xpath("//button[@data-unify='Select']")).click();
        Thread.sleep(2000L);
        //driver.findElement(By.xpath("//*[text()[contains(.,'Terbaru')]]")).click();
        driver.findElement(By.xpath("//li/button/div/div/p[text()[contains(.,'Terbaru')]]")).click();
        Thread.sleep(3000L);
        driver.findElement(By.xpath("//label/span[text()[contains(.,'Official Store')]]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='spnSRPProdName']"))).findElements(By.xpath("//div[@data-testid='spnSRPProdName']"));
        for(int i=0;i<10;i++){
            System.out.println(search.get(i).getAttribute("innerHTML"));
        }
        driver.close();
    }
}
