package ru.yandex.practicum.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.yandex.practicum.pages.constants.Urls.HOME_PAGE_URL;

public class HomePage {
    private final WebDriver driver;

    private final By topOrderButtonSelector = By.xpath(".//*[starts-with(@class,'Header_Header')]//button[text()='Заказать']");
    private final By bottomOrderButtonSelector = By.xpath(".//*[starts-with(@class,'Home_ThirdPart')]//button[text()='Заказать']");

    private AccordionItem accordionItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(HOME_PAGE_URL);
    }

    public void clickTopOrderButton() {
        WebElement element = this.driver.findElement(this.topOrderButtonSelector);
        element.click();
    }

    public void clickBottomOrderButton() {
        WebElement element = this.driver.findElement(this.bottomOrderButtonSelector);
        this.scrollToElement(element);
        element.click();
    }

    public AccordionItem getAccordionItem(int index) {
        this.accordionItem = new AccordionItem(this.driver, index);

        return this.accordionItem;
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
    }
}