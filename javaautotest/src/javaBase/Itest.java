/**
 * Created by sogaa001 on 2019/12/21.
 */


package javaBase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;    //鼠标操作
import org.openqa.selenium.support.ui.WebDriverWait;    //等待
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;           //下拉框
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;  //需要导入commons-io jar包
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.IOException;

/*
1、元素定位：Selenium提供了8种定位方式。

id
name
class name
tag name
link text
partial link text
xpath
css selector
这8种定位方式在Python selenium中所对应的方法为：

findElement(By.id())
findElement(By.name())
findElement(By.className())
findElement(By.tagName())
findElement(By.linkText())
findElement(By.partialLinkText())
findElement(By.xpath())
findElement(By.cssSelector())

 */

/*
//2、控制浏览器前进后退
public class Itest{
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        //get 到百度
        driver.get("https://www.baidu.com/");
        System.out.printf("now access %s \n", driver.getCurrentUrl());

        //当前进程休眠2000毫秒,即2s
        Thread.sleep(2000);

        //元素定位
        driver.findElement(By.linkText("新闻")).click();
        System.out.printf("now process %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);

        //浏览器后退
        driver.navigate().back();

        //刷新页面
        driver.navigate().refresh();
        System.out.printf("back to %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);

        //前进
        driver.navigate().forward();
        System.out.printf("forward to %s \n", driver.getCurrentUrl());
        Thread.sleep(2000);


        driver.quit();
    }
}
*/

//3、其他方法
/*
public class Itest {
    public static void main(String []  args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        WebElement search_text = driver.findElement(By.id("kw"));
        WebElement search_button = driver.findElement(By.id("su"));

        //输入
        search_text.sendKeys("Java Selenium");

        //清除文本
        search_text.clear();
        search_text.sendKeys("Selenium");
        //单击
        search_button.click();

        driver.quit();

    }
}
*/

/*4、控制浏览器
public class Itest {
    public static void  main(String [] args){

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        //提交表单
        WebElement search_text = driver.findElement(By.id("kw"));
        search_text.sendKeys("Selnium");
        search_text.submit();


        //获取尺寸
        WebElement size = driver.findElement(By.id("kw"));
        System.out.println(size.getSize());

        //获取元素文本
        WebElement text = driver.findElement(By.id("cp"));
        System.out.println(text.getText());

        //获取属性值
        WebElement ty = driver.findElement(By.id("kw"));
        System.out.println(ty.getAttribute("type"));

        //设置元素是否可见
        WebElement display = driver.findElement(By.id("kw"));
        System.out.println(display.isDisplayed());

        //perform执行所有A刺痛中存储的行为
        WebElement search_setting = driver.findElement(By.linkText("设置"));
        Actions action = new Actions(driver);
        //鼠标悬停
        action.clickAndHold(search_setting).perform();

        //右击
        action.contextClick(driver.findElement(By.id("element"))).perform();

        //双击
        action.doubleClick(driver.findElement(By.id("element"))).perform();

        //推拽
        WebElement source = driver.findElement(By.name("element"));
        WebElement target = driver.findElement(By.name("element"));
        action.dragAndDrop(source, target).perform();


        driver.quit();


    }

}
*/

/*5、
public class Itest {
    public static void main(String [] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://baidu.com");

        WebElement input = driver.findElement(By.id("kw"));

        //显式等待
        WebDriverWait wait = new WebDriverWait(driver,10,1);


        //输入框输入内容
        input.sendKeys("seleniumm");
        Thread.sleep(2000);

        //键盘操作，删除多输入的一个 m
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);

        wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver text) {
                return text.findElement(By.id("kw"));
                }
            }).sendKeys("selenium");

        }
    }
    */

/*6、设置等待
//implicitlyWait:识别对象时的超时时间
//setScriptTimeout。异步脚本的超时时间。WebDriver可以异步执行脚本，这个是设置异步执行脚本脚本返回结果的超时时间。
//pageLoadTimeout。页面加载时的超时时间。因为WebDriver会等页面加载完毕再进行后面的操作，所以如果页面超过设置时间依然没有加载完成，那么WebDriver就会抛出异常。

public class Itest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //页面加载超时时间设置5s
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("https://baidu.com");

        ////定位对象时给 10s 的时间, 如果 10s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("kw")).sendKeys("selenium");

        ////异步脚本的超时时间设置成 3s
        driver.manage().timeouts().setScriptTimeout(3,TimeUnit.SECONDS);

        driver.quit();
    }
}

*/

//7、定位一组元素：与定位单个元素的方法类似，唯一的区别是在单词 findElement 后面多了一个 s 表示复数。
/*
findElements(By.id())
findElements(By.name())
findElements(By.className())
findElements(By.tagName())
findElements(By.linkText())
findElements(By.partialLinkText())
findElements(By.xpath())
findElements(By.cssSelector())
 */
/*
public class Itest {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        WebElement search_text = driver.findElement(By.id("kw"));
        search_text.sendKeys("selenium");
        search_text.submit();
        Thread.sleep(2000);

        //匹配第一页结果，循环打印
        List<WebElement> search_result = driver.findElements(By.xpath("//div/div/h3"));

        //打印元素个数
        System.out.println(search_result.size());

        //循环打印搜索结果的标题
        for(WebElement result : search_result) {
            System.out.println(result.getText());
        }

        System.out.println("----------分隔线-------------");

        //打印第n结果的标题
        WebElement text = search_result.get(search_result.size() - 10);
        System.out.println(text.getText());

        driver.quit();
    }
}
*/

//7、多表单切换：switchTo().frame()
/*
public class Itest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.126.com");

        WebElement xf = driver.findElement(By.xpath("//*[@id='loginDiv']/frame"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("username");
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("username");
        driver.findElement(By.id("dologin")).click();
        driver.switchTo().defaultContent(); //跳出表单
    }
}
*/

//8、多窗口切换:switchTo().window()
/*
public class Itest {

    public static void main(String[] arge) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        //获得当前窗口句柄
        String search_handle = driver.getWindowHandle();

        //打开百度注册窗口
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("立即注册")).click();

        //获得所有窗口句柄
        Set<String> handles = driver.getWindowHandles();

        //判断是否为注册窗口， 并操作注册窗口上的元素
        for(String handle : handles){
            if (handle.equals(search_handle)==false){
                //切换到注册页面
                driver.switchTo().window(handle);
                System.out.println("now register window!");
                Thread.sleep(2000);
                driver.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys("user name");
                driver.findElement(By.name("phone")).clear();
                driver.findElement(By.name("phone")).sendKeys("phone number");
                //......
                Thread.sleep(2000);
                //关闭当前窗口
                driver.close();
            }
        }
        Thread.sleep(2000);

        driver.quit();
    }
}
*/

//9、下拉框选择:Select类
//10、警告框处理
/*
getText()： 返回 alert/confirm/prompt 中的文字信息。

accept()： 接受现有警告框。

dismiss()： 解散现有警告框。

sendKeys(keysToSend)： 发送文本至警告框。

keysToSend： 将文本发送至警告框。
 */
/*
public class Itest {
    public static void main(String [] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        driver.findElement(By.linkText("设置")).click();
        driver.findElement(By.linkText("搜索设置")).click();
        Thread.sleep(2000);

        //<select>标签的下拉框选择
        WebElement el = driver.findElement(By.xpath("//select"));
        Select sel = new Select(el);
        Thread.sleep(2000);

        //保存设置
        driver.findElement(By.className("prefpanelgo")).click();

        //接受弹窗
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.quit();
    }
}
*/

//11、文件上传:input标签实现的上传功能，即通过sendKeys()指定本地文件路径的方式实现文件上传。
/*
public class Itest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        File file = new File("./HTMLFile/upfile.html");
        String filePath = file.getAbsolutePath();
        driver.get(filePath);

        //定位上传按钮， 添加本地文件
        driver.findElement(By.name("file")).sendKeys("D:\\upload_file.txt");
        Thread.sleep(5000);

        driver.quit();
    }
}
*/

//12、cookie操作
/*
getCookies() 获得所有 cookie 信息。

getCookieNamed(String name) 返回字典的key为“name”的Cookie信息。

addCookie(cookie dict) 添加Cookie。“cookie_dict”指字典对象，必须有 name和value值。

deleteCookieNamed(String name) 删除Cookie 信息。 “name”是要删除的 cookie的名称； “optionsString” 是该Cookie的选项，目前支持的选项包括“路径” ， “域” 。

deleteAllCookies() 删除所有 cookie 信息。
 */

/*
public class Itest {
    public static void main(String [] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        Cookie c1 = new Cookie("name", "key-aaaa");
        Cookie c2 = new Cookie("value", "value-bbbb");
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);

        //获取cookie
        Set<Cookie> coo = driver.manage().getCookies();
        System.out.println(coo);

        driver.quit();
    }
}
*/

//13、调用JavaScript
/*
public class Itest {
    public static void main(String [] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(700, 600));
        driver.get("http://www.baidu.com");

        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("window.scrollTo(100, 450);");
        Thread.sleep(3000);

        driver.quit();
    }
}
*/

//14、窗口截图
public class Itest {

    public static void main(String[] arge){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File("E:\\javaProject\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}














