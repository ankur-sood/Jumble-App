package ca.ankur.jumbleapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * The dictionary, which is the model of this app.
 *
 * @author Franck van Breugel
 */
public class Dictionary
{
    //METHOD 1
    static HashMap<String, HashMap<Character,Integer>> outerMap = new HashMap<String, HashMap<Character, Integer>>();
    static HashMap<Character,Integer> innerMap = new HashMap<Character, Integer>();

    static HashMap<String, HashMap<Character,Integer>> outerMap2 = new HashMap<String, HashMap<Character, Integer>>();
    static HashMap<Character,Integer> innerMap2 = new HashMap<Character, Integer>();

    //METHOD 2
    static HashMap<String, String> anagramsSorted = new HashMap<String, String>();


    /**
     * Initializes this dictionary from the given file.  Each line of the file contains a
     * single word.
     *
     * @param file file containing the words of this dictionary.
     */

    public Dictionary(File file)

    /**
     * METHOD 1: FREQUENCY OF LETTERS
     */
    /*
    {
        try
        {
            Scanner input = new Scanner(file);

            while (input.hasNextLine())
            {
                String s = input.nextLine();
                for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    Integer val = innerMap.get(new Character(c));
                    if(val != null){
                        innerMap.put(c, new Integer(val + 1));
                    }else{
                        innerMap.put(c,1);
                    }
                    outerMap.put(s,innerMap);
                }
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            // do nothing
        }
    }
    */

    /**
     * METHOD 2: SORTED CHARACTERS
     *
     * Takes input string, converts to array of characters, sorts characters alphabetically, converts back to string, adds to HashMap 'anagramsSorted'
     */
    {
        try {
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String s = input.nextLine();        //Scans unsorted string
                char[] c = s.toCharArray();         //Convert to array of chars
                java.util.Arrays.sort(c);           //Sort
                String newString = new String(c);   //Convert back to String
                anagramsSorted.put(s,newString);    //Add to HashMap --> original word, sorted word
            }
            input.close();
        } catch (FileNotFoundException e) {
            // do nothing
        }
    }


    /**
     * Returns the list of words that are unscramblings of the given word.
     *
     * @param word word to be unscrambled.
     * @return list of words that are unscramblings of the given word.
     */

    public List<String> getUnscramblings(String word)

    /**
     * METHOD 1: FREQUENCY OF LETTERS
     */
    /*
    {

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            Integer val = innerMap2.get(new Character(c));
            if(val != null){
                innerMap2.put(c, new Integer(val + 1));
            }else{
                innerMap2.put(c,1);
            }
            outerMap2.put(word,innerMap2);
        }

        if(outerMap.containsValue(outerMap2)){
            List.
        }
    }
    */

    /**
     * METHOD 2: SORTED CHARACTERS
     */
    {
        char[] c = word.toCharArray();        //Convert to array of chars
        java.util.Arrays.sort(c);             //Sort
        String sortedWord = new String(c);    //Convert back to String

        ArrayList result = new ArrayList<String>();
        for (Map.Entry<String,String> entry : anagramsSorted.entrySet()) {
            if (entry.getValue().equals(sortedWord)) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}