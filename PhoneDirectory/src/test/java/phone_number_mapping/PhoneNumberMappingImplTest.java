package phone_number_mapping;

import org.hamcrest.CoreMatchers;
import static org.hamcrest.Matchers.*;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PhoneNumberMappingImpl.class)
public class PhoneNumberMappingImplTest {

    @InjectMocks
    PhoneNumberMappingImpl phoneNumberMapping;

    @Test
    public void get_0() {
        //given
        int i = 0;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, hasSize(0));
    }

    @Test
    public void get_1() {
        //given
        int i = 0;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, hasSize(0));
    }

    @Test
    public void get_2() {
        //given
        int i = 2;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('A', 'B', 'C'));
    }

    @Test
    public void get_3() {
        //given
        int i = 3;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('D', 'E', 'F'));
    }

    @Test
    public void get_4() {
        //given
        int i = 4;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('G', 'H', 'I'));
    }

    @Test
    public void get_5() {
        //given
        int i = 5;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('J', 'K', 'L'));
    }

    @Test
    public void get_6() {
        //given
        int i = 6;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('M', 'N', 'O'));
    }

    @Test
    public void get_7() {
        //given
        int i = 7;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('P', 'Q', 'R','S'));
    }

    @Test
    public void get_8() {
        //given
        int i = 8;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('T', 'U', 'V'));
    }

    @Test
    public void get_9() {
        //given
        int i = 9;

        // when
        List<Character> characterList = phoneNumberMapping.get(i);

        //then
        MatcherAssert.assertThat(characterList, CoreMatchers.hasItems('W','X', 'Y', 'Z'));
    }

}