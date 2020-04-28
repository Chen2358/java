package javaBase;

/**
 * Created by sogaa001 on 2019/12/23.
 */
//导入JUnit jar包和Java hamcrest jar包


import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;


public class JUnitest {

    @Test
    public void testAdd() {
        Count count = new Count();
        int result = count.add(2,2);
        assertEquals(result, 4);
    }

    //超时验证
    @Test(timeout=100)
    public void testAdd1() throws InterruptedException {
        Thread.sleep(101);
        new Count().add(1, 1);
    }

    //验证抛出异常
    @Test(expected = ArithmeticException.class)
    public void testDivision() {
        new Count().division(8,0);
    }

    //跳过该用例
    @Ignore
    @Test
    public void testAdd2() {
        Count count =  new Count();
        int result = count.add(2, 2);
        assertEquals(result,  5);
    }
}
