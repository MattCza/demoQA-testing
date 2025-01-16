package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;

public class CheckBoxPage extends ElementsPage {
    private By expendAllButton = By.xpath("//button[@class='rct-option rct-option-expand-all']");

    private By publicItem = By.xpath("//div[@class='check-box-tree-wrapper']//span[text()='Public']");
    private By excelFile = By.xpath("//div[@class='check-box-tree-wrapper']//span[text()='Excel File.doc']");
    private By excelFileCheckBox = By.id("tree-node-excelFile");
    private By wordFile = By.xpath("//div[@class='check-box-tree-wrapper']//span[text()='Word File.doc']");
    private By wordFileCheckBox = By.id("tree-node-wordFile");
//    private By selectedItems = By.xpath("//span[@class='text-success']");

//    List<WebElement> selectedElements = driver.findElements(By.cssSelector("span.text-success"));
//    List<String> selectedItems = new ArrayList<>();


    public void clickExpendAllButton() {
        click(expendAllButton);
    }

    public void clickPublicItem() {
        scrollToElementJavaScript(publicItem);
        click(publicItem);
    }

    public void clickExcelFile() {
        scrollToElementJavaScript(excelFile);
        click(excelFile);
    }

    public List<String> getSelectedItems() {
        List<WebElement> selectedElements = driver.findElements(By.cssSelector(".text-success"));
        List<String> selectedItems = new ArrayList<>();

        for (WebElement element : selectedElements) {
            String itemText = element.getText().trim();
            if (!itemText.isEmpty()) {
                selectedItems.add(itemText);
            }
        }
        return selectedItems;
    }

    public boolean isExcelFileSelected(){
        return find(excelFileCheckBox).isSelected();
    }

    public boolean isWordFileSelected(){
        return find(wordFileCheckBox).isSelected();
    }


}
