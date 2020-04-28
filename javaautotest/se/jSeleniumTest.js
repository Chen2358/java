/**
 * Created by sogaa001 on 2019/12/24.
 */

/*
//1、示例
var webdriver = require('selenium-webdriver'),
    By = webdriver.By;

var Key = webdriver.Key;

var dr = new webdriver.Builder().forBrowser('chrome').build();
dr.get('http://www.qq.com');

// 把页面的body找到，在body上模拟按钮，这是整页面模拟按键事件的小技巧
var body = dr.findElement(By.css("body"));

// 每隔1.5s按一次空格键
// setTimeout在js binding中相当于其他binding中的sleep功能
for (var i = 0; i < 10; i++) {
    setTimeout(function() {
        body.sendKeys(Key.SPACE);
    }, i * 1500);
}
*/

//2、定位一组元素
/*
var webdriver = require('selenium-webdriver'),
    By = webdriver.By;

var dr = new webdriver.Builder().forBrowser('chrome').build();
dr.get('http://www.testclass.net/selenium_javascript/');

dr.findElements(By.css('.post-stub a')).then(function(links){
    for (var i = 0; i < links.length; i++) {
        links[i].getAttribute('href').then(function(href) {
            console.log(href);
        });
    }
});

dr.quit()

*/

//3、执行js
/*
var path = require('path');
var webdriver = require('selenium-webdriver'),
    By = webdriver.By;

var url = "http://www.baidu.com/";

var dr = new webdriver.Builder().forBrowser('chrome').build();
dr.get(url)

// 先隐藏掉百度一下按钮
// 通过arguments[0]传入百度一下按钮
var hideBtn = "arguments[0].style.display='none';"

dr.executeScript(hideBtn, dr.findElement(By.id('su')));


// 然后返回页面上所有导航链接的文本
// 通过return返回需要的结果
var linkTexts = "return $('.mnav').text()"
dr.executeScript(linkTexts).then(function(texts) {
    console.log(texts);
});

// 最后把页面背景变成黑色

dr.executeScript("document.body.style.backgroundColor='black'");
*/

//3、截图

var webdriver = require('selenium-webdriver'),
    By = webdriver.By

var Key = webdriver.Key;

var dr = new webdriver.Builder().forBrowser('chrome').build();
dr.get('http://www.testclass.net/selenium_javascript/');
dr.takeScreenshot().then(function (data) {
    require('fs').writeFile('pic.png', data, 'base64');
    dr.quit();
})

















