import com.microsoft.playwright.*;

import java.util.ArrayList;

public class MouseHover {
    public static void main(String[] args) {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(arguments).setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://www.way2automation.com/");
        page.locator("//*[@id='menu-item-27580']/a/span[2]").hover();
        page.locator("//*[@id='menu-item-27582']/a/span[2]").hover();
        page.locator("//*[@id='menu-item-27583']/a/span[2]").click();
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
