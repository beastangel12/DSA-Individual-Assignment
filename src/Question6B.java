//You are given an array of different words and target words. Each character of a word represents a different
//digit ranging from 0 to 9, and no two character are linked to same digit. If the sum of the numbers represented
//by each word on the array equals the sum the number represented by the targeted word, return true; otherwise,
//return false. Note: Provided list of words and targeted word is in the form of equation
//Input: words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"

public class Question6B {

    private char[] letters = {'S', 'I', 'X', 'E', 'V', 'N', 'T', 'W', 'Y'};
    private int[] values = {6, 5, 0, 8, 7, 2, 1, 3, 4};

    // check sum of words equals to sum of result letters
    public boolean showResult(String[] words, String result){
        return getWordsValue(words) == Integer.parseInt(getEachValue(result));
    }
    // returns value of the array i.e words
    public int getWordsValue(String[] words){
        int wordValue = 0;
        // get each word
        for(String word: words){
            // get each word value by calling a function and convert the String into int value for addition
            wordValue += Integer.parseInt(getEachValue(word));
        }
        return wordValue;
    }

    // returns values of the word
    public String getEachValue(String word){
        String letterValue = "";
        char letter;
        for(int i = 0; i< word.length(); i++){
            // get each letter of the word
            letter = word.charAt(i);
            // get the value of the word
            letterValue += getValueOf(letter);
        }

        return letterValue;
    }

    //  returns value of each letter
    public int getValueOf(char letter){
        // search letter
        for(int i = 0; i < letters.length; i++){
            // if found
            if(letters[i] == letter){
                return values[i];
            }
        }
        // throw error if the value does not find
        throw new IllegalAccessError();

    }
    public static void main(String[] args){

        Question6B answer = new Question6B();

        String[] words = {"SIX","SEVEN","SEVEN"};
        String result = "TWENTY";

        // final output
        System.out.println(answer.showResult(words, result));

        // for confirming/testing
        int wordsValue = answer.getWordsValue(words);
        System.out.println("Words value : " + wordsValue);

        String resultValue = answer.getEachValue(result);
        System.out.println("Result value : " + resultValue);


    }


}