import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.ArrayList;
import java.util.List;

public class DropDownDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://www.wikipedia.org/");
        page.locator("#searchInput").fill("marvel movies list");
//        page.selectOption("select","ta");
//        page.selectOption("select",new SelectOption().setIndex(3));
//        page.selectOption("select",new SelectOption().setLabel("Cymraeg"));
//        page.selectOption("select",new SelectOption().setValue("ta"));
//        Locator dropDownList = page.locator("select > option");
//        System.out.println("Total Count "+dropDownList.count());
//        for (int i=0;i<dropDownList.count();i++){
//            System.out.println(dropDownList.nth(i).innerText()+"----"+dropDownList.nth(i).getAttribute("lang"));
//        }
        List<ElementHandle> dropDownList = page.querySelectorAll("select > option");
        System.out.println("Total Count "+dropDownList.size());
        for(ElementHandle dropDown : dropDownList){
            System.out.println(dropDown.innerText()+"----"+dropDown.getAttribute("lang"));
        }


//        page.click("button:has-text('Search')");

    }
}
