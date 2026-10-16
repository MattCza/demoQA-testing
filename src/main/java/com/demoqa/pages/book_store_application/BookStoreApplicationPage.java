package com.demoqa.pages.book_store_application;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class BookStoreApplicationPage extends HomePage {

    public static final String PATH = "/books";

    public BookStoreApplicationPage(WebDriver driver) {
        super(driver);
    }

    public BookStoreApplicationPage open() {
        openPath(PATH);
        return this;
    }
}