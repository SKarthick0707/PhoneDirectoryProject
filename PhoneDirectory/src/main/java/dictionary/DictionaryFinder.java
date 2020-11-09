package dictionary;

import dictionary.source.DictionarySourceFactory;
import phone_number_mapping.PhoneNumberMapping;
import phone_number_mapping.PhoneNumberMappingFactory;

import java.util.ArrayList;
import java.util.List;

public class DictionaryFinder {

    Dictionary dictionary;
    PhoneNumberMapping phoneNumberMapping;
    char[] number;
    List<String> output = new ArrayList<>();
    Boolean unknowNumber;

    public DictionaryFinder(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.phoneNumberMapping = PhoneNumberMappingFactory.getPhoneNumberMapping();
    }

    public String findPhoneNumber(String phoneNumber) {
        this.number = phoneNumber.toCharArray();
        find(0, dictionary.getCharList(), new ArrayList<>(), 0);
        return getResult();
    }

    private String getResult() {
        if ((unknowNumber != null && unknowNumber) || output.isEmpty()) {
            return null;
        }
        String result = null;
        boolean isNumber = false;
        for (String word : output) {
            if (result == null) {
                result = word;
                isNumber = isStrNumber(word);
                continue;
            }
            boolean isPrevWordNumber = isNumber;
            isNumber = isStrNumber(word);
            if (isPrevWordNumber && isNumber) {
                result = result + "" + word;
            } else {
                result = result + "-" + word;
            }

        }
        return result;
    }

    private boolean isStrNumber(String str) {
        return str.matches("(0|[0-9]\\d*)");
    }

    private void find(int curr_digit, List<Data> charList, List<Character> characterList, int consecutiveUnKnowNum) {
        if (curr_digit == number.length) {
            return;
        }

        char ch = number[curr_digit];
        if (ch < 48 || ch > 57) {
            find(curr_digit + 1, charList, characterList, consecutiveUnKnowNum);
            return;
        }

        int num = Integer.parseInt(String.valueOf(ch));
        if (num == 0 || num == 1) {
//            consecutiveUnKnowNum++;
            characterList.add((char)(num+48));
//            if (curr_digit == number.length-1) {
//                output.add(convertToString(characterList));
//                return;
//            }
            find(curr_digit + 1, charList, characterList, consecutiveUnKnowNum);
            return;
        }

        if (consecutiveUnKnowNum == 2) {
            unknowNumber = true;
            return;
        }


        boolean charFoundInDict = false;
        for (int i = 0; i < phoneNumberMapping.get(num).size(); i++) {
            List<Character> tempList = new ArrayList<>();
            tempList.addAll(characterList);
            Character character = phoneNumberMapping.get(num).get(i);
            Data data = Dictionary.getData(charList, character);
            if (data == null) {
                continue;
            }
            charFoundInDict = true;
            tempList.add(character);
            if (data.isWord()) {
                unknowNumber = false; // resetting the value
                output.add(convertToString(tempList));
                find(curr_digit + 1, dictionary.getCharList(), new ArrayList<>(), 0);
            } else {
                find(curr_digit + 1, data.getNextCharList(), tempList, consecutiveUnKnowNum);
            }
        }

//        if (!charFoundInDict) {
//            consecutiveUnKnowNum++;
//            characterList.add((char) (num + 48));
////            output.add(convertToString(characterList));
//            find(curr_digit + 1, dictionary.getCharList(), new ArrayList<>(), consecutiveUnKnowNum);
//        }

//        if (curr_digit == number.length-1) {
//            characterList.add((char) (num + 48));
//            output.add(convertToString(characterList));
//            return;
//        }

    }


    private String convertToString(List<Character> characterList) {
        return characterList.toString().replaceAll("[,\\s\\[\\]]", "");
    }


    public static void main(String[] args) {
        String number = "323410";
        Dictionary dictionary = Dictionary.getDictionary(DictionarySourceFactory.getDictionarySource());
        DictionaryFinder dictionaryFinder = new DictionaryFinder(dictionary);
        dictionaryFinder.findPhoneNumber(number);
        System.out.println("Printing the result in list");
        System.out.println(dictionaryFinder.output);
    }

}
