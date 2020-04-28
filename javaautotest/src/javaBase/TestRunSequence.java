package javaBase;

/**
 * Created by sogaa001 on 2019/12/23.
 */

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;

//按字母顺序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunSequence {

    @Test
    public void TestCase1() {
        assertEquals(2+2,4);
    }

    @Test
    public void TestCase2() {
        assertEquals(2+2, 4);
    }

    //按字母顺序最先执行
    @Test
    public void TestAa() {
        assertEquals("hello", "hi");
    }
}
