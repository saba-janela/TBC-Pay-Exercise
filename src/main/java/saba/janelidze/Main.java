package saba.janelidze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;


import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saba.Janelidze\\Downloads\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tbcpay.ge");

    // #1 მომხმარებელი შედის საიტზე, ჩატვირთულ გვერდზე შეამოწმე შემდეგი ელემენტების არსებობა:

        // ჰედერის ნავიგაცია: 'სერვისები', 'გადარიცხვები', 'ბიზნესისთვის', 'გადაიხადე უცხოეთიდან'.
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bg-blue-700")));
        String headerText = header.getText();

        assertTrue(headerText.contains("სერვისები"), "ელემენტი 'სერვისები' არ არსებობს");
        assertTrue(headerText.contains("გადარიცხვები"), "ელემენტი 'გადარიცხვები' არ არსებობს");
        assertTrue(headerText.contains("ბიზნესისთვის"), "ელემენტი 'ბიზნესისთვის' არ არსებობს");
        assertTrue(headerText.contains("გადაიხადე უცხოური ბარათით"), "ელემენტი 'გადაიხადე უცხოური ბარათით' არ არსებობს");

        // სერვისების ნავიგაცია: 'მობილური ბალანსის შევსება', 'ბანკები, სხვა ფინანსური მომსახურება', 'ტოტალიზატორები კაზინო ლატარია', 'ინტერნეტი ტელეფონი ტელევიზია', 'კომუნალური გადასახადები', 'ტრანსპორტი  ჯარიმები  ტაქსი', 'სახელმწიფო სერვისები', 'სხვადასხვა განათლება ქველმოქმედება'.
        WebElement servicesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("სერვისები")));
        servicesBtn.click();

        WebElement services = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sticky.top-40.border-gray-300.md\\:border-r")));
        String servicesText = services.getText();

        assertTrue(servicesText.contains("მობილური ბალანსის შევსება"), "ელემენტი 'მობილური ბალანსის შევსება' არ არსებობს");
        assertTrue(servicesText.contains("ბანკები, სხვა ფინანსური მომსახურება"), "ელემენტი 'ბანკები, სხვა ფინანსური მომსახურება' არ არსებობს");
        assertTrue(servicesText.contains("ტოტალიზატორები კაზინო ლატარია"), "ელემენტი 'ტოტალიზატორები კაზინო ლატარია' არ არსებობს");
        assertTrue(servicesText.contains("ინტერნეტი ტელეფონი ტელევიზია"), "ელემენტი 'ინტერნეტი ტელეფონი ტელევიზია' არ არსებობს");
        assertTrue(servicesText.contains("ტრანსპორტი ჯარიმები ტაქსი"), "ელემენტი 'ტრანსპორტი ჯარიმები ტაქსი' არ არსებობს");
        assertTrue(servicesText.contains("სახელმწიფო სერვისები"), "ელემენტი 'სახელმწიფო სერვისები' არ არსებობს");
        assertTrue(servicesText.contains("სხვადასხვა განათლება ქველმოქმედება"), "ელემენტი 'სხვადასხვა განათლება ქველმოქმედება' არ არსებობს");

        // საძიებო ველი ღილაკით „ძიება“
        WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='material-icons' and text()='home']")));
        homeBtn.click();

        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='relative top-px right-0.5 overflow-hidden text-ellipsis whitespace-nowrap text-sm font-medium text-gray-500']")));
        WebElement searchBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount\"]/main/div/div[1]/div[1]/button/div/span")));
        String searchBtnText = searchBtn.getText();

        assertEquals(searchBtnText, "ძიება");

    // #2 ძიების ველში ჩაწერე "მობილური", გამოსულ სიაში უნდა შეამოწმო შემდეგის არსებობა:

        // მობილური ბალანსის შევსება
        searchBar.click();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='w-full rounded-full py-4 px-14 font-medium text-blue-700 placeholder:text-sm placeholder:font-medium placeholder:text-gray-500 md:px-18.5 md:py-5']")));
        searchInput.sendKeys("მობილური");

        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='მობილური ბალანსის შევსება']")));

    // #3 დააჭირე ტექსტს "მობილური ბალანსის შევსება", შეამოწმე შემდეგი ელემენტების არსებობა.

        //ტელეფონის ნომრის შესაყვანი ველი
        searchResult.click();

        WebElement numInputBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service_input")));

        //ღილაკი „შემოწმება“
        WebElement numInputBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service_input_submit_button")));

    // #4 ტელეფონის ნომრის ველში ჩაწერე '555122334', ველში უნდა ჩაიწეროს ნომერი სრულად
        numInputBar.click();
        numInputBar.sendKeys("555122334");

    // #5 დააჭირე ველს, აირჩიეთ სერვისი, ჩამოშლილ სიაში შეამოწმე:

        // ბალანსის შევსება
        numInputBtn.click();

        WebElement chooseService = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='flex select-none items-center overflow-hidden whitespace-nowrap text-sm font-medium text-gray-600 md:left-3 cursor-pointer visible absolute top-2 left-3 right-8']")));
        chooseService.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='ბალანსის შევსება']")));

        // "მეტი" - 8 ₾
        WebElement more = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='მეტი']")));
        more.click();

        WebElement moreChooseService = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='flex select-none items-center overflow-hidden whitespace-nowrap text-sm font-medium text-gray-600 md:left-3 cursor-pointer visible absolute top-2 left-3 right-8']")));
        moreChooseService.click();

        WebElement more10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='მეტი მ 10₾ / 30 დღე']")));

    // #6 დააჭირე ტექსტს "მეტი - 10 ₾", შეამოწმე შემდეგის არსებობა:

        //ტექსტი: დავალიანება / 10.00 c
        more10.click();

        WebElement debtText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid items-center justify-items-start gap-3 md:grid-cols-[152px_1fr]']")));
        assertTrue(debtText.getText().contains("დავალიანება"));
        assertTrue(debtText.getText().contains("10.00 c"));

        //ტექსტი: თანხის ოდენობა c / შესაყვანი ველი ტექსტით: 10
        WebElement debtText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid items-start justify-items-start gap-3 md:grid-cols-[152px_1fr]']")));
        assertTrue(debtText2.getText().contains("თანხის ოდენობა c"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='h-10 w-full max-w-[8rem] rounded-lg border border-black/20 px-4 font-medium read-only:bg-grey-200 disabled:bg-grey-200 text-xl' and @name='1327' and @value='10']")));

        //ტექსტი: საკომისიო 0.12 c
        WebElement commissionText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount\"]/main/main/div[1]/div[1]/div[5]/div[1]/div/div[3]/div[1]/button")));
        assertTrue(commissionText.getText().contains("საკომისიო"));

        WebElement commissionAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount\"]/main/main/div[1]/div[1]/div[5]/div[1]/div/div[3]/div[2]/button")));
        assertTrue(commissionAmount.getText().contains("0.12c"));

    // #7 დააჭირე ღილაკს 'გადახდა' უნდა ჩაიტვირთოს გვერდი ახალი დომენზე ecommerce.ufc.ge
//        WebElement purchaseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='inline-block rounded-lg bg-pink-500 px-4 py-2 text-base font-bold text-white disabled:cursor-not-allowed disabled:opacity-80']")));
        WebElement purchaseBtn = driver.findElement(By.xpath("//button[@class='inline-block rounded-lg bg-pink-500 px-4 py-2 text-base font-bold text-white disabled:cursor-not-allowed disabled:opacity-80']"));

        assertTrue(purchaseBtn.getText().contains("გადახდა"));
        purchaseBtn.click();

        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_modal_close_button")));
        closeBtn.click();

        assertTrue(wait.until(ExpectedConditions.urlContains("ecommerce.ufc.ge")));

        driver.quit();
    }
}
