import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class LinkDemo {
    public static void main(String[] args) {
        ArrayList<String> arguments= new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://www.wikipedia.org/");
        // Iterate Link in Web Page
/*        Locator linkList = page.locator("a");
        System.out.println("Total Links "+linkList.count());
        for (int i=0;i<linkList.count();i++){
            System.out.println(linkList.nth(i).innerText()+"----"+linkList.nth(i).getAttribute("href"));
        }*/

        //Iterate Specific Block of Link
/*        Locator block = page.locator("//*[@id=\"www-wikipedia-org\"]/main/nav[1]");
        Locator blockOfLinkList = block.locator("a");
        System.out.println("Total Links "+blockOfLinkList.count());
        for (int i=0;i<blockOfLinkList.count();i++){
            System.out.println(blockOfLinkList.nth(i).innerText()+"----"+blockOfLinkList.nth(i).getAttribute("href"));
        }*/

        //Using QuerySelector
        List<ElementHandle> linkList = page.querySelectorAll("a");
        System.out.println("Total Links "+linkList.size());
        for(ElementHandle link : linkList){
            System.out.println(link.innerText()+"-----"+link.getAttribute("href"));
        }
    }
}
