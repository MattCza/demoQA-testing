package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.config.Config;
import com.demoqa.pages.elements.LinksPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {

    @Test
    public void simpleLinkOpensHomePageInNewTab() {
        LinksPage linksPage = new LinksPage(driver()).open();

        String newTabUrl = linksPage.openSimpleLinkAndGetNewTabUrl();

        Assert.assertEquals(newTabUrl, Config.baseUrl() + "/", "Simple link opened an unexpected page");
        Assert.assertEquals(linksPage.getOpenWindowCount(), 1, "New tab was not closed");
        Assert.assertEquals(linksPage.getCurrentPath(), LinksPage.PATH, "Did not return to the Links page");
    }

    @DataProvider
    public Object[][] apiLinks() {
        return new Object[][]{
                {"created", 201, "Created"},
                {"no-content", 204, "No Content"},
                {"moved", 301, "Moved Permanently"},
                {"bad-request", 400, "Bad Request"},
                {"unauthorized", 401, "Unauthorized"},
                {"forbidden", 403, "Forbidden"},
                {"invalid-url", 404, "Not Found"},
        };
    }

    @Test(dataProvider = "apiLinks")
    public void apiLinkShowsResponseStatus(String linkId, int expectedCode, String expectedText) {
        LinksPage linksPage = new LinksPage(driver()).open();

        linksPage.clickApiLink(linkId);

        Assert.assertEquals(linksPage.getResponseStatusCode(), expectedCode, "Status code for '" + linkId + "'");
        Assert.assertEquals(linksPage.getResponseStatusText(), expectedText, "Status text for '" + linkId + "'");
    }
}
