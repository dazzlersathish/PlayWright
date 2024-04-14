import com.microsoft.playwright.*;

import java.util.ArrayList;

public class IFrameDemo {
    public static void main(String[] args) {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://seleniumbase.io/w3schools/iframes");
        Locator listOfFrame = page.locator("iframe");
        System.out.println("Total List " + listOfFrame.count());
        for (int i = 0; i < listOfFrame.count(); i++) {
            System.out.println(listOfFrame.nth(i).getAttribute("id"));
        }
        FrameLocator frameLocator = page.frameLocator("#iframeResult");
        String headline = frameLocator.locator("body > p").innerText();
        System.out.println("Main Frame "+headline);
        FrameLocator innerFrameLocator = frameLocator.frameLocator("iframe");
        String innerHeadline = innerFrameLocator.locator("body > h1").innerText();
        System.out.println("Inner Frame "+innerHeadline);
    }
}
