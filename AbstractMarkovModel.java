
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String key) { 
        int pos = 0;
        int idx = 0;
        //System.out.println("The string has " + myText.length() + " characters.");
        ArrayList<String> follow = new ArrayList<String>();
        while(true) {
            idx = myText.indexOf(key,pos);
            if( idx == -1 || idx == myText.length()-key.length())       
                break;
            pos = idx+key.length();
            follow.add(myText.substring(pos,pos+1));
            //System.out.println("pos "+pos);
        }
        return follow;
    }
}
