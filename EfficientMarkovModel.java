
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel {
    private int modelNumber;

    public EfficientMarkovModel(int number) {
        myRandom = new Random();
        modelNumber = number;
    }

    public String toString() {
        return "MarkovModel of order "+ modelNumber;
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public HashMap<String,ArrayList<String>> buildMap() { 
        int start =0;
        int end = 1;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> mainMap = new HashMap<String, ArrayList<String>>();
        String ch ="";
        ArrayList<String> charFollow = new ArrayList<String>();
        for(int k=0; k<myText.length(); k++) {
            ch = myText.substring(start,end);

            if(!map.containsKey(ch)) {
                charFollow = getFollows(ch);
                map.put(ch, charFollow );
                String chCopy = ch;
                for(String s : charFollow) {
                    String newKey = chCopy+s;
                    if(!mainMap.containsKey(newKey)) {
                        ArrayList<String> charFollowCopy = getFollows(newKey);
                        mainMap.put(newKey, charFollowCopy);
                    }
                }

            }
            if(charFollow.size()==0) {
                break;
            }

            start += 1;
            end += 1;
        }


        return mainMap;
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-modelNumber);
        String key = myText.substring(index, index+modelNumber);
        sb.append(key);
        HashMap<String, ArrayList<String>> mainMap = buildMap();
        ArrayList<String> follows = new ArrayList<String>();
        ArrayList<String> charFollow = new ArrayList<String>();
        for(int k=0; k < numChars-modelNumber; k++){            
            if(mainMap.containsKey(key))
            {
                follows = mainMap.get(key);
            }
            /*
            else if(!mainMap.containsKey(key))
            {   
                charFollow = getFollows(key);
                mainMap.put(key, charFollow);
                follows = mainMap.get(key);
            }
            */
            if(follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1)+next;
        }
        printHashMapInfo(mainMap);
        return sb.toString();
    }

    public void printHashMapInfo(HashMap<String, ArrayList<String>> map) {
        for(String s : map.keySet()) {
            System.out.println("Key: "+s+", Value: "+map.get(s));
        }

        System.out.println("There are "+map.size()+" keys in the map.");
    }
}
