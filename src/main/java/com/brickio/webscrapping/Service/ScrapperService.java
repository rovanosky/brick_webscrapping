package com.brickio.webscrapping.Service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScrapperService {

    private static final String url = "https://www.tokopedia.com/p/handphone-tablet/handphone";

    @PostConstruct
    public void scrape () throws InterruptedException{
        ChromeDriver driver = new ChromeDriver();
        ChromeDriver driverDetail = new ChromeDriver();
        driver.get(url);
        final List<WebElement> productList = driver.findElementsByClassName("css-89jnbj");

        Thread.sleep(4000);

        productList.forEach(product -> {
            driverDetail.get(product.getAttribute("href"));
            
            final WebElement productName = driverDetail.findElementByClassName("css-1wtrxts");
            final WebElement productDetail = driverDetail.findElementByClassName("e1iszlzh1");
            final WebElement productImage = driverDetail.findElementByClassName("css-1b60o1a");
            final WebElement productPrice = driverDetail.findElementByClassName("price");
            final WebElement productRating = driverDetail.findElementByClassName("css-zeq6c8");
            final WebElement productStore = driverDetail.findElementByClassName("css-1n8curp");

            System.out.println(productName.getText());
            System.out.println(productDetail.getText());

            final WebElement image = productImage.findElement(By.tagName("img"));
            System.out.println(image.getText());


            System.out.println(productPrice.getText());
            System.out.println(productRating.getText());

            final WebElement store = productStore.findElement(By.tagName("h2"));
            System.out.println(store.getText());

        });
        driver.quit();
    }

}
