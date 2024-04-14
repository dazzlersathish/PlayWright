import com.microsoft.playwright.*;

import java.util.ArrayList;

public class CheckBoxDemo {
    public static void main(String[] args) {
        ArrayList<String> argument = new ArrayList<>();
        argument.add("--start-maximized");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(argument));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://ultimateqa.com/simple-html-elements-for-automation/");
        Locator listOfCheckBox = page.locator("//input[@type='checkbox']");
        System.out.println("Total Count "+listOfCheckBox.count());
        for (int i=0;i<listOfCheckBox.count();i++){
            System.out.println(listOfCheckBox.nth(i).innerText()+"----"+listOfCheckBox.nth(i).getAttribute("value"));
            listOfCheckBox.nth(i).setChecked(true);
        }
/*        for (int i=0;i<listOfCheckBox.count();i++){
            System.out.println("next line");
            if (listOfCheckBox.nth(i).isChecked()) {
                System.out.println("next line2");
                System.out.println(listOfCheckBox.nth(i).innerText() + "----" + listOfCheckBox.nth(i).getAttribute("value"));
                listOfCheckBox.nth(i).click();
            }
        }*/
    }
}
