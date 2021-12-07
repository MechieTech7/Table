package Task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {
    static void Table() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://html.com/tables/");
        driver.manage().window().maximize();

     List <WebElement> rows = driver.findElements(By.xpath("//table[@class='related-elements']/tbody/tr"));
     List  <WebElement> columns = driver.findElements(By.xpath("//table[@class='related-elements']/tbody/tr/th"));
     int rowNum = rows.size();
     int colNum = columns.size();
        System.out.println(rowNum);
        System.out.println(colNum);
        for(int i=1; i<= columns.size(); i++){
            for(int j=2;j<=rows.size(); j++){
                WebElement content = driver.findElement(By.xpath("//table[@class='related-elements']/tbody/tr[8]/td[3]"));
                String table = content.getText();
                System.out.println(table);
            }
        }
       // System.out.println(driver.findElement(By.xpath("//table[@class='related-elements']/tbody/tr[8]/td[3]")).getText());


    }

    public static void main(String[] args) {
        Table();
    }
}
