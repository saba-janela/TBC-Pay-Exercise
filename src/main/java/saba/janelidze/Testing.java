package saba.janelidze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static saba.janelidze.Startup.wait;

public class Testing {

    public static void testing() {
        checkHeaderNavigation();
        checkServicesNavigation();
        checkSearchFunctionality();
        checkMobileBalanceService();
        checkPhoneNumberInput();
        checkServiceSelection();
        checkBalanceRecharge();
        verifyPurchaseRedirection();
    }

    private static void checkHeaderNavigation() {
        String headerText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bg-blue-700"))).getText();

        assertTrue(headerText.contains("სერვისები"), "ელემენტი 'სერვისები' არ არსებობს");
        assertTrue(headerText.contains("გადარიცხვები"), "ელემენტი 'გადარიცხვები' არ არსებობს");
        assertTrue(headerText.contains("ბიზნესისთვის"), "ელემენტი 'ბიზნესისთვის' არ არსებობს");
        assertTrue(headerText.contains("გადაიხადე უცხოური ბარათით"), "ელემენტი 'გადაიხადე უცხოური ბარათით' არ არსებობს");
    }

    private static void checkServicesNavigation() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("სერვისები"))).click();

        String servicesText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sticky.top-40.border-gray-300.md\\:border-r"))).getText();

        assertTrue(servicesText.contains("მობილური ბალანსის შევსება"), "ელემენტი 'მობილური ბალანსის შევსება' არ არსებობს");
        assertTrue(servicesText.contains("ბანკები, სხვა ფინანსური მომსახურება"), "ელემენტი 'ბანკები, სხვა ფინანსური მომსახურება' არ არსებობს");
        assertTrue(servicesText.contains("ტოტალიზატორები კაზინო ლატარია"), "ელემენტი 'ტოტალიზატორები კაზინო ლატარია' არ არსებობს");
        assertTrue(servicesText.contains("ინტერნეტი ტელეფონი ტელევიზია"), "ელემენტი 'ინტერნეტი ტელეფონი ტელევიზია' არ არსებობს");
        assertTrue(servicesText.contains("ტრანსპორტი ჯარიმები ტაქსი"), "ელემენტი 'ტრანსპორტი ჯარიმები ტაქსი' არ არსებობს");
        assertTrue(servicesText.contains("სახელმწიფო სერვისები"), "ელემენტი 'სახელმწიფო სერვისები' არ არსებობს");
        assertTrue(servicesText.contains("სხვადასხვა განათლება ქველმოქმედება"), "ელემენტი 'სხვადასხვა განათლება ქველმოქმედება' არ არსებობს");
    }

    private static void checkSearchFunctionality() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='material-icons' and text()='home']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='relative top-px right-0.5 overflow-hidden text-ellipsis whitespace-nowrap text-sm font-medium text-gray-500']")));
        String searchBtnText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount\"]/main/div/div[1]/div[1]/button/div/span"))).getText();

        assertEquals(searchBtnText, "ძიება");
    }

    private static void checkMobileBalanceService() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='relative top-px right-0.5 overflow-hidden text-ellipsis whitespace-nowrap text-sm font-medium text-gray-500']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='w-full rounded-full py-4 px-14 font-medium text-blue-700 placeholder:text-sm placeholder:font-medium placeholder:text-gray-500 md:px-18.5 md:py-5']"))).sendKeys("მობილური");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='მობილური ბალანსის შევსება']"))).click();;
    }

    private static void checkPhoneNumberInput() {
        WebElement numInputBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service_input")));
        WebElement numInputBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("service_input_submit_button")));

        numInputBar.click();
        numInputBar.sendKeys("555122334");
        numInputBtn.click();
    }

    private static void checkServiceSelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='flex select-none items-center overflow-hidden whitespace-nowrap text-sm font-medium text-gray-600 md:left-3 cursor-pointer visible absolute top-2 left-3 right-8']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='ბალანსის შევსება']")));
    }

    private static void checkBalanceRecharge() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='მეტი']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='flex select-none items-center overflow-hidden whitespace-nowrap text-sm font-medium text-gray-600 md:left-3 cursor-pointer visible absolute top-2 left-3 right-8']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='მეტი მ 10₾ / 30 დღე']"))).click();

        WebElement debtText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid items-center justify-items-start gap-3 md:grid-cols-[152px_1fr]']")));
        assertTrue(debtText.getText().contains("დავალიანება"));
        assertTrue(debtText.getText().contains("10.00 c"));

        WebElement debtText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='grid items-start justify-items-start gap-3 md:grid-cols-[152px_1fr]']")));
        assertTrue(debtText2.getText().contains("თანხის ოდენობა c"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='h-10 w-full max-w-[8rem] rounded-lg border border-black/20 px-4 font-medium read-only:bg-grey-200 disabled:bg-grey-200 text-xl' and @name='1327' and @value='10']")));

        WebElement commissionText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount\"]/main/main/div[1]/div[1]/div[5]/div[1]/div/div[3]/div[1]/button")));
        assertTrue(commissionText.getText().contains("საკომისიო"));

        WebElement commissionAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount\"]/main/main/div[1]/div[1]/div[5]/div[1]/div/div[3]/div[2]/button")));
        assertTrue(commissionAmount.getText().contains("0.12c"));
    }

    private static void verifyPurchaseRedirection() {
        WebElement purchaseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='inline-block rounded-lg bg-pink-500 px-4 py-2 text-base font-bold text-white disabled:cursor-not-allowed disabled:opacity-80']")));
        assertTrue(purchaseBtn.getText().contains("გადახდა"));
        purchaseBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login_modal_close_button"))).click();

        assertTrue(wait.until(ExpectedConditions.urlContains("ecommerce.ufc.ge")));
    }
}
