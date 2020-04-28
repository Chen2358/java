package javaBase;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Created by sogaa001 on 2019/12/23.
 */
public class TestFixture {

    //在当前测试类开始时运行
    @BeforeClass
    public static void beforeClass() {
        System.out.println("----------------------------beforeClass\n");
    }

    //在当前测试类结束时运行
    @AfterClass
    public static void afterClass() {
        System.out.println("----------------------------afterClass");
    }

    //每个测试方法运行前执行
    @Before
    public void before(){
        System.out.println("=====before");
    }

    //每个测试方法运行后执行
    @After
    public void after() {
        System.out.println("===============after");
    }

    @Test
    public void testAdd1() {
        int result = new Count().add(5, 3);
        assertEquals(8, result);
        System.out.println("test run testadd1");
    }

    @Test
    public void testAdd2() {
        int result = new Count().add(15, 13);
        assertEquals(28, result);
        System.out.println("test run testadd2");
    }


}
