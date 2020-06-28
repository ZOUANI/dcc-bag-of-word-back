package ma.zs.tfidf.util;

import ma.zs.tfidf.bean.Bag;

import java.util.List;

public class Util {

    //remove ponctuations from a given string
    public static String removePunctuation(String s){
        return s.replaceAll("\\p{Punct}", " ");
    }

    //check if term is already counted
    public static boolean exist(List<Bag> bags, String term) {
        for (Bag bag : bags) {
            if (bag.getWord().equalsIgnoreCase(term)) {
                return true;
            }
        }
        return false;
    }

    //Check if term should be ignored
    public static boolean ignored(String[] arr, String term) {
        for (String s : arr) {
            if (s.equalsIgnoreCase(term)) {
                return true;
            }
        }
        return false;
    }

}
