package ru.yandex.practicum.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccordionItem {
    private final WebDriver driver;

    private final By questionElementSelector;
    private final By answerElementSelector;

    public AccordionItem(WebDriver driver, int index) {
        this.driver = driver;
        this.questionElementSelector = By.cssSelector("#accordion__heading-" + index);
        this.answerElementSelector = By.cssSelector("#accordion__panel-" + index + " p");
    }

    public void expandQuestion() {
        WebElement element = this.driver.findElement(questionElementSelector);
        this.scrollToElement(element);
        element.click();
    }

    public String getQuestionLabelText() {
        WebElement element = this.driver.findElement(questionElementSelector);
        this.scrollToElement(element);

        return element.getText();
    }

    public String getAnswerLabelText() {
        WebElement element = this.driver.findElement(answerElementSelector);
        this.scrollToElement(element);

        return element.getText();
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
    }
}
