import org.junit.*;
import org.junit.Test;

public class NumberFormatterTest {
    String string;
    NumberFormatter numFor=new NumberFormatter();


    @Test
    public void TestAllMethod(){
        string="-764";
        int expected=-764;
        Assert.assertEquals(expected, numFor.parseInt(string)); }

    @Test
    public void TestMethod(){
        string="764";
        int expected=764;
        Assert.assertEquals(expected, numFor.convertStringInput(string)); }


    @Test
    public void TestingMinus(){
        string="-764";
        int expected=-764;
        Assert.assertEquals(expected, numFor.convertStringInputWithMinus(string)); }

    @Test
    public void TestingPlus(){
        string="+764";
        int expected=764;
        Assert.assertEquals(expected, numFor.convertStringInputWithPlus(string)); }
    @Test
    public void TestingZero(){
        string="10000";
        char[]chars=string.toCharArray();
        int expected=10000;
        Assert.assertEquals(expected,numFor.getQuantityOfZero(chars));
    }
}
