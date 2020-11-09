package phone_number_mapping;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMappingImpl implements PhoneNumberMapping {

    private static PhoneNumberMappingImpl phoneNumberMapping;

    Map<Integer, List<Character>> phoneNumberMap;

    private PhoneNumberMappingImpl() {
        phoneNumberMap = new HashMap<>();
        load();
    }

    private void load() {
        for (int i = 0; i < 10; i++) {
            List<Character> characterList = new ArrayList<>();
            switch (i) {
                case 0:
                case 1:
                    break;
                case 2:
                    characterList.add('A');
                    characterList.add('B');
                    characterList.add('C');

                    break;
                case 3:
                    characterList.add('D');
                    characterList.add('E');
                    characterList.add('F');
                    break;
                case 4:
                    characterList.add('G');
                    characterList.add('H');
                    characterList.add('I');
                    break;
                case 5:
                    characterList.add('J');
                    characterList.add('K');
                    characterList.add('L');
                    break;
                case 6:
                    characterList.add('M');
                    characterList.add('N');
                    characterList.add('O');
                    break;
                case 7:
                    characterList.add('P');
                    characterList.add('Q');
                    characterList.add('R');
                    characterList.add('S');
                    break;
                case 8:
                    characterList.add('T');
                    characterList.add('U');
                    characterList.add('V');
                    break;
                case 9:
                    characterList.add('W');
                    characterList.add('X');
                    characterList.add('Y');
                    characterList.add('Z');
                    break;


            }
            phoneNumberMap.put(i, characterList);
        }

    }

    @Override
    public List<Character> get(int number) {
        return phoneNumberMap.get(number);
    }

    public static PhoneNumberMapping getPhoneNumberMapping() {
        if(phoneNumberMapping != null){
            return phoneNumberMapping;
        }
        return phoneNumberMapping = new PhoneNumberMappingImpl();
    }

}
