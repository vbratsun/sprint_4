package ru.yandex.practicum.pages.home;

import org.openqa.selenium.WebDriver;

import static ru.yandex.practicum.pages.constants.Urls.HOME_PAGE_URL;

public class HomePage {
    private final WebDriver driver;
    private AccordionItem accordionItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(HOME_PAGE_URL);
    }

    public AccordionItem getAccordionItem(int index) {
        this.accordionItem = new AccordionItem(this.driver, index);

        return this.accordionItem;
    }
}