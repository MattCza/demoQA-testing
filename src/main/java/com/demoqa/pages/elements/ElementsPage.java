package com.demoqa.pages.elements;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends HomePage {
    public static final String PATH = "/elements";

    // Menu item ids (item-0, item-1, ...) repeat in every menu group, so items are located by their route.
    private By textBoxItem = By.cssSelector("a[href='/text-box']");
    private By checkBoxItem = By.cssSelector("a[href='/checkbox']");
    private By webTablesItem = By.cssSelector("a[href='/webtables']");
    private By buttonsItem = By.cssSelector("a[href='/buttons']");
    private By linksItem = By.cssSelector("a[href='/links']");
    private By dynamicPropertiesItem = By.cssSelector("a[href='/dynamic-properties']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage open() {
        openPath(PATH);
        return this;
    }

    public TextBoxPage clickTextBoxItem() {
        scrollToElementJavaScript(textBoxItem);
        click(textBoxItem);
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickCheckBoxItem() {
        scrollToElementJavaScript(checkBoxItem);
        click(checkBoxItem);
        return new CheckBoxPage(driver);
    }

    public WebTablesPage clickWebTablesItem() {
        scrollToElementJavaScript(webTablesItem);
        click(webTablesItem);
        return new WebTablesPage(driver);
    }

    public ButtonsPage clickButtonsItem() {
        scrollToElementJavaScript(buttonsItem);
        click(buttonsItem);
        return new ButtonsPage(driver);
    }

    public LinksPage clickLinksItem() {
        scrollToElementJavaScript(linksItem);
        click(linksItem);
        return new LinksPage(driver);
    }

    public DynamicPropertiesPage clickDynamicPropertiesItem() {
        scrollToElementJavaScript(dynamicPropertiesItem);
        click(dynamicPropertiesItem);
        return new DynamicPropertiesPage(driver);
    }


}
