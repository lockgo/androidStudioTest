package com.examples.lapgar.testr2;

/**
 * Created by Lapgar on 10/28/2014.
 */
public class classyTest extends abstractionTest implements interfaceTest
{
    String testStrings = "You got in here";

    public classyTest(String tempString)
    {
        testStrings = tempString;
    }

    public String printInterfaceTest()
    {
        testAbstractMethod();
        return testStrings + " " + reText();
    }

    @Override
    void testAbstractMethod()
    {
        this.newText = "How abstract";

    }
}
