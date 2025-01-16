package com.demoqa.pages.elements;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;

public class ElementsPage extends HomePage {

    private By textBoxItem = By.xpath("//li[@id='item-0']/span[text()='Text Box']");
    private By checkBoxItem = By.xpath("//li[@id='item-1']/span[text()='Check Box']");
    private By radioButtonItem = By.xpath("//li[@id='item-2']/span[text()='Radio Button']");
    private By webTablesItem = By.xpath("//li[@id='item-3']/span[text()='Web Tables']");
    private By buttonsItem = By.xpath("//li[@id='item-4']/span[text()='Buttons']");
    private By linksItem = By.xpath("//li[@id='item-5']/span[text()='Links']");
    private By brokenLinksImagesItem = By.xpath("//li[@id='item-6']/span[contains(text(), 'Broken')]");
    private By uploadAndDownloadItem = By.xpath("//li[@id='item-7']/span[contains(text(), 'Upload')]");
    private By dynamicPropertiesItem = By.xpath("//li[@id='item-8']/span[contains(text(), 'Dynamic')]");

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


}
