import com.microsoft.playwright.*;

import java.util.ArrayList;

public class dialogAlertDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> argument = new ArrayList<>();
        argument.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(argument));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");
        Thread.sleep(2000);

        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept();




































































        });
        page.locator("[type='submit']").click();
    }
}
