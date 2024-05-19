import com.microsoft.playwright.*;

import java.util.ArrayList;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://jqueryui.com/droppable/");
        Thread.sleep(5000);
        FrameLocator frameLocator = page.frameLocator("iframe");
        Locator sourceElement = frameLocator.locator("//*[@id='draggable']");
        Locator destinationElement = frameLocator.locator("//*[@id='droppable']");
        page.mouse().move(sourceElement.boundingBox().x + sourceElement.boundingBox().width/2,sourceElement.boundingBox().y + sourceElement.boundingBox().height/2);
        page.mouse().down();
        page.mouse().move(destinationElement.boundingBox().x + destinationElement.boundingBox().width/2,destinationElement.boundingBox().y + destinationElement.boundingBox().height/2);
        page.mouse().up();
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
