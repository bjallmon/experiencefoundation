package com.ef.hotpotato;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HotPotatoTest {

    @Test
    public void returnsHelloWorld() {
        assertEquals("Hello World!", HotPotato.Hello());
    }

    @Test
    public void echoesInput() {
        assertEquals("Hello World!", HotPotato.echo("Hello World!"));
    }

    @Test
    public void echoListOfStrings() {
        List<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("Hello World");
        listOfStrings.add("Goodnight Moon!");

        assertEquals("Hello World\nGoodnight Moon!", HotPotato.echoList(listOfStrings));
    }

    @Test
    public void mapOfEchosAndLineSize() {
        List<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("Hello World");
        listOfStrings.add("Goodnight Moon!");

        Map<String, ?> result = HotPotato.echoListAndSize(listOfStrings);
        assertEquals("Hello World\nGoodnight Moon!", result.get("text"));
        assertEquals(2, result.get("size"));
    }

}
