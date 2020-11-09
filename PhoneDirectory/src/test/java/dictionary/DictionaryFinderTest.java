package dictionary;

import dictionary.source.DictionarySource;
import org.hamcrest.MatcherAssert;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryFinderTest {

    DictionarySource dictionarySource;

    Dictionary dictionary;

    DictionaryFinder dictionaryFinder;


    @Test
    public void findPhoneNumber_valid1() {

        // given
        dictionarySource = Mockito.mock(DictionarySource.class);
        List<String> list = new ArrayList<>();
        list.add("cool");
        list.add("be");
        BDDMockito.given(dictionarySource.list()).willReturn(list);
        dictionary =  Dictionary.getDictionary(dictionarySource);
        dictionaryFinder = new DictionaryFinder(dictionary);


        //when
        String result = dictionaryFinder.findPhoneNumber("2665");

        //then
        assertEquals("COOL",result);
    }

    @Test
    public void findPhoneNumber_valid2() {

        // given
        dictionarySource = Mockito.mock(DictionarySource.class);
        List<String> list = new ArrayList<>();
        list.add("cool");
        list.add("be");
        BDDMockito.given(dictionarySource.list()).willReturn(list);
        dictionary =  Dictionary.getDictionary(dictionarySource);
        dictionaryFinder = new DictionaryFinder(dictionary);


        //when
        String result = dictionaryFinder.findPhoneNumber("12665");

        //then
        assertEquals("1COOL",result);
    }

    @Test
    public void findPhoneNumber_valid3() {

        // given
        dictionarySource = Mockito.mock(DictionarySource.class);
        List<String> list = new ArrayList<>();
        list.add("cool");
        list.add("be");
        BDDMockito.given(dictionarySource.list()).willReturn(list);
        dictionary =  Dictionary.getDictionary(dictionarySource);
        dictionaryFinder = new DictionaryFinder(dictionary);


        //when
        String result = dictionaryFinder.findPhoneNumber("102665");

        //then
        assertEquals("10COOL",result);
    }

    @Test
    public void findPhoneNumber_valid4() {

        // given
        dictionarySource = Mockito.mock(DictionarySource.class);
        List<String> list = new ArrayList<>();
        list.add("cool");
        list.add("be");
        BDDMockito.given(dictionarySource.list()).willReturn(list);
        dictionary =  Dictionary.getDictionary(dictionarySource);
        dictionaryFinder = new DictionaryFinder(dictionary);


        //when
        String result = dictionaryFinder.findPhoneNumber("82665");

        //then
        assertEquals("8COOL",result);
    }

    @Test
    public void findPhoneNumber_valid5() {

        // given
        dictionarySource = Mockito.mock(DictionarySource.class);
        List<String> list = new ArrayList<>();
        list.add("cool");
        list.add("be");
        BDDMockito.given(dictionarySource.list()).willReturn(list);
        dictionary =  Dictionary.getDictionary(dictionarySource);
        dictionaryFinder = new DictionaryFinder(dictionary);


        //when
        String result = dictionaryFinder.findPhoneNumber("232665");

        //then
        assertEquals("BE-COOL",result);
    }

    @Test
    public void findPhoneNumber_invalid1() {

        // given
        dictionarySource = Mockito.mock(DictionarySource.class);
        List<String> list = new ArrayList<>();
        list.add("cool");
        list.add("be");
        BDDMockito.given(dictionarySource.list()).willReturn(list);
        dictionary =  Dictionary.getDictionary(dictionarySource);
        dictionaryFinder = new DictionaryFinder(dictionary);


        //when
        String result = dictionaryFinder.findPhoneNumber("342665");

        //then
        assertEquals(null,result);
    }

}