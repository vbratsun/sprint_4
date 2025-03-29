package ru.yandex.practicum.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private final String HOME_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private WebDriver driver;
    private AccordionItem accordionItem;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(this.HOME_PAGE_URL);
    }

    public AccordionItem getAccordionItem(int index) {
        this.accordionItem = new AccordionItem(this.driver, index);

        return this.accordionItem;
    }
}