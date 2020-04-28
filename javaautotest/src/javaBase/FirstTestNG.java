package javaBase;

/**
 * Created by sogaa001 on 2019/12/23.
 */


import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.assertEquals;

/*
//1、简单使用
public class FirstTestNG {

    @Test
    public void testCase() {
        assertEquals(2+2, 4);
    }
}
*/

//2、fixture
/*
public  class FirstTestNG {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("--------------------beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("-------------------afterClass");
    }

    @BeforeMethod
    public void before() {
        System.out.println("===========beforeMethod");
    }

    @AfterMethod
    public void after() {
        System.out.println("===========afterMethod");
    }

    @Test
    public void testCase1() {
        System.out.println("test case1");
    }

    @Test
    public void testCase2() {
        System.out.println("test case2");
    }
}

*/

//3、TestNG用例依赖
/*
public  class FirstTestNG {
    @Test
    public void testAdd1(){
        assertEquals(3+1, 5);
    }

    @Test(dependsOnMethods = {"testAdd1"})
    public void testAdd2(){
        assertEquals(3+2, 5);
    }

}
*/

//4、参数化-@Parameters
/*
public  class FirstTestNG {
    @Test
    @Parameters({"add1", "add2", "result"})
    public void testAdd1(int add1, int add2, int result) {
        assertEquals(add1, add2, result);
    }

}
*/

//4、参数化-@DataProvider
public  class FirstTestNG {

    //定义对象数组
    @DataProvider(name="add")
    public Object[][] Users() {
        return new Object[][] {
                { 3, 2, 5 },
                { 2, 2, 4 },
                { 3, 3, 7 },
        };
    }

    @Test(dataProvider = "add")
    public void testAdd1(int add1, int add2, int result) {
        assertEquals(add1+add2, result);
    }

}

















