package com.demoqa.pages.elements;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;

public class ElementsPage extends HomePage {

    // Menu item ids (item-0, item-1, ...) repeat in every menu group, so items are located by their route.
    private By textBoxItem = By.cssSelector("a[href='/text-box']");
    private By checkBoxItem = By.cssSelector("a[href='/checkbox']");
    private By radioButtonItem = By.cssSelector("a[href='/radio-button']");
    private By webTablesItem = By.cssSelector("a[href='/webtables']");
    private By buttonsItem = By.cssSelector("a[href='/buttons']");
    private By linksItem = By.cssSelector("a[href='/links']");
    private By brokenLinksImagesItem = By.cssSelector("a[href='/broken']");
    private By uploadAndDownloadItem = By.cssSelector("a[href='/upload-download']");
    private By dynamicPropertiesItem = By.cssSelector("a[href='/dynamic-properties']");

    public TextBoxPage clickTextBoxItem() {
        scrollToElementJavaScript(textBoxItem);
        click(textBoxItem);
        return new TextBoxPage();
    }

    public CheckBoxPage clickCheckBoxItem() {
        scrollToElementJavaScript(checkBoxItem);
        click(checkBoxItem);
        return new CheckBoxPage();
    }

    public WebTablesPage clickWebTablesItem() {
        scrollToElementJavaScript(webTablesItem);
        click(webTablesItem);
        return new WebTablesPage();
    }

    public ButtonsPage clickButtonsItem() {
        scrollToElementJavaScript(buttonsItem);
        click(buttonsItem);
        return new ButtonsPage();
    }

    public LinksPage clickLinksItem() {
        scrollToElementJavaScript(linksItem);
        click(linksItem);
        return new LinksPage();
    }

    public DynamicPropertiesPage clickDynamicPropertiesItem() {
        scrollToElementJavaScript(dynamicPropertiesItem);
        click(dynamicPropertiesItem);
        return new DynamicPropertiesPage();
    }


}
