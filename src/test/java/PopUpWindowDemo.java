import com.microsoft.playwright.*;

import java.util.ArrayList;

public class PopUpWindowDemo {
    public static void main(String[] args) {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://www.irctc.co.in/nget/train-search");
        Page popup  = page.waitForPopup(()->{
             page.locator("//a[contains(text(),'BUSES')]").click();
        });
        System.out.println(popup.title());
        popup.close();
    }
}
