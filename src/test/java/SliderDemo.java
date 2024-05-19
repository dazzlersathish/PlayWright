import com.microsoft.playwright.*;

import java.util.ArrayList;

public class SliderDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://jqueryui.com/slider/");
        Thread.sleep(5000);
        FrameLocator frameLocator = page.frameLocator("iframe");
        Locator redSlider = frameLocator.locator("//*[@id='slider']/span");

        page.mouse().move(redSlider.boundingBox().x + redSlider.boundingBox().width/2,redSlider.boundingBox().y + redSlider.boundingBox().height/2);
//        page.mouse().move(redSlider.boundingBox().x + 400,redSlider.boundingBox().y + redSlider.boundingBox().height/2);
        page.mouse().down();

    }
}
