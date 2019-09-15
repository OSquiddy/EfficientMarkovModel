
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
        String newKey ="";
        ArrayList<String> followList = new ArrayList<String>();
        ArrayList<String> newList = new ArrayList<String>();
        for(int k=0; k<myText.length(); k++) {
            ch = myText.substring(start,end);
            if(!map.containsKey(ch)) {
                start += 1;
                end += 1;
                map.put(ch, new ArrayList<String>());
                int mapSize = map.size();
            }
            else if(map.containsKey(ch)) 
            {   
                start +=1;
                end +=1;
                continue;
            }
            
        }

        for(String key : map.keySet()) {
            followList = map.get(key);
            followList = getFollows(key);
            newKey = key;
            for(String s : followList) {
                newKey = key;
                newKey += s;
                if(!map.containsKey(newKey)) {
                    newList = getFollows(newKey);

                    mainMap.put(newKey, newList);

                }
            }

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
            
            if(follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1)+next;
        }
        //printHashMapInfo(mainMap);
        return sb.toString();
    }

    public void printHashMapInfo(HashMap<String, ArrayList<String>> map) {
        for(String s : map.keySet()) {
            System.out.println("Key: "+s+", Value: "+map.get(s));
        }
        System.out.println("There are "+map.size()+" keys in the map.");
        
        int max =0;
        for(ArrayList<String> list : map.values()) {
            if( max<list.size()) {
                max = list.size();
            }
        }
        System.out.println("The max value in the HashMap is " + max);
        
        System.out.println("\nThe keys with the max values are: ");
        for(String s : map.keySet()) {
            if( map.get(s).size() == max) {
                System.out.println("Key : "+s+" "+map.get(s));
            }
        }
    }
}

