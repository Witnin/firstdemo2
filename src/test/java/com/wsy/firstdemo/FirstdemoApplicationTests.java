package com.wsy.firstdemo;

import com.wsy.firstdemo.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import junit.framework.Assert;

import java.util.Calendar;

@SpringBootTest
class FirstdemoApplicationTests {

    @Test
    void contextLoads() {
        Calendar src = Calendar.getInstance();
        src.set(2021, Calendar.APRIL, 29);
        Calendar result = DateUtil.addDateByWorkDay(src, 2);
        Calendar expected = Calendar.getInstance();
        expected.set(2021, Calendar.MAY, 4);
        Assert.assertEquals(expected.getTime().toString(), result.getTime().toString());
    }

@Test
public void testAddDateByWorkDay2()
{
//测试母亲节
Calendar src = Calendar.getInstance();
src.set(2021, Calendar.JULY , 11);
Calendar result = DateUtil.addDateByWorkDay(src, 5);
Calendar expected = Calendar.getInstance();
expected.set(2021, Calendar.JULY , 16);
Assert.assertEquals(expected.getTime().toString(), result.getTime().toString());
}


}
