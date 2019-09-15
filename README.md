# EfficientMarkovModel
Based on Assignment 3 given in the 3rd week of Duke University's 'Java Programming: Principles of Software Design' course on Coursera.

The question as given in the assignment : "Write a new class named EfficientMarkovModel (make a copy of MarkovModel to start with) that extends AbstractMarkovModel and that builds a HashMap to calculate the follows ArrayList for each possible substring only once, and then uses the HashMap to look at the list of characters following when it is needed. This class should include:

    1. a toString method to print that this is the EfficientMarkovModel class of a specific number
    2. a method named buildMap to build the HashMap (Be sure to handle the case where there may not be a follow character. If that key          is not in the HashMap yet, then it should be put in mapped to an empty ArrayList.) Think carefully about where to call this              method, considering that you will want to build a map for each new training text.
    3. a getFollows method, but this getFollows method should be much shorter, as it can look up the ArrayList of Strings, instead of          computing it each time.

To test your HashMap to make sure it is built correctly, write the void method printHashMapInfo in the EfficientMarkovModel class. Make sure to call this method immediately after building the map. This method should print out the following information about the HashMap:

    Print the HashMap (all the keys and their corresponding values). Only do this if the HashMap is small.
    Print the number of keys in the HashMap
    Print the size of the largest value in the HashMap—that is, the size of the largest ArrayList of characters
    Print the keys that have the maximum size value.
    
Write a new method named testHashMap in the MarkovRunnerWithInterface class. This method should create an order-2 EfficientMarkovModel with

    seed 42
    the training text is “yes-this-is-a-thin-pretty-pink-thistle”
    the size of the text generated is 50
    Note that “le” occurs only once at the end of the training text

In the MarkovRunnerWithInterface class, call testHashMap. You should see that the HashMap has the following information:
    
    It has 25 keys in the HashMap
    The maximum number of keys following a key is 3
    Keys that have the largest ArrayList (of size 3 in this case) are: “hi”, “s-”, “-t”, “is”, and “th”
    After running it, you’ll probably want to comment out the call to printHashMapInfo in the EfficientMarkovModel class.

In the MarkovRunnerWithInterface class, create a void method named compareMethods that runs a MarkovModel and an EfficientMarkovModel. In particular,

    Make both order-2 Markov models
    Use seed 42 and set the length of text to generate to be 1000
    Both should call runModel that generates random text three times for each.
    Run the MarkovModel first and then the EfficientMarkovModel with the file “hawthorne.txt” as the training text. One of them should       be noticeably faster. You can calculate the time each takes by using System.nanoTime() for the current time."

## v1.0
The 
