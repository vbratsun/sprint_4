package ru.yandex.practicum.pages.order;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentLengthPeriod {
    private final WebDriver driver;

    private final By rentLengthPeriodSelector = By.cssSelector(".Dropdown-root");
    private By rentLengthPeriodItemSelector;

    public RentLengthPeriod(WebDriver driver) {
        this.driver = driver;
    }

    public void setRentLengthPeriod(String rentLengthPeriod) {
        this.expandMenu();

        this.rentLengthPeriodItemSelector = By.xpath(".//*[@class='Dropdown-option' and text()='"+rentLengthPeriod+"']");
        WebElement element = driver.findElement(this.rentLengthPeriodItemSelector);
        this.scrollToElement(element);
        element.click();
    }

    public void expandMenu(){
        WebElement element = driver.findElement(this.rentLengthPeriodSelector);
        element.click();
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
    }
}
