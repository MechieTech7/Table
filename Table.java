import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.get("http://www.leafground.com/pages/table.html");
        driver.navigate().to("http://www.leafground.com/pages/table.html");

        List<WebElement> columns = driver.findElements(By.tagName("th"));
        int count1 = columns.size();
        System.out.println(count1);

        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        int count = rows.size();
        System.out.println(count);

        WebElement percent = driver.findElement(By.xpath("//td[normalize-space()= 'Learn to interact with Elements']//following::td[1]"));
        String val = percent.getText();
        System.out.println(val);

        List<WebElement> last = driver.findElements(By.xpath("//td[2]"));
        List<Integer> numList = new ArrayList<Integer>();

        for (WebElement webElement : last) {
            String unique = webElement.getText().replace("%", "");
            numList.add(Integer.parseInt(unique));


        }
        System.out.println(numList);

        int smallValue = Collections.min(numList);
        System.out.println(smallValue);
        String sV = Integer.toString(smallValue) + "%";

        String xPath = "//td[normalize-space()=" + "\"" + sV + "\"" + "]" + "//following::td[1]";

        WebElement tough = driver.findElement(By.xpath(xPath));
        tough.click();
    }
}
