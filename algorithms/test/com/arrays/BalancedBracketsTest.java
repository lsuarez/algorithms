package com.arrays;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBracketsTest {
    @Test
    public void validString(){
        Assert.assertEquals("YES",BalancedBrackets.isBalanced("{(([])[])[]}"));
        Assert.assertEquals("NO", BalancedBrackets.isBalanced("{[(])}"));
        Assert.assertEquals("YES", BalancedBrackets.isBalanced("{{[[(())]]}}"));
        Assert.assertEquals("NO", BalancedBrackets.isBalanced("["));
        Assert.assertEquals("NO", BalancedBrackets.isBalanced("{[}"));
    }
}
