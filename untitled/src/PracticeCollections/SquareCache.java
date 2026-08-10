package PracticeCollections;

import java.util.HashMap;
import java.util.Map;

public class SquareCache {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int getSquare(int num){
        if(cache.containsKey(num)) return cache.get(num);
        else {
            int square = num*num;
            cache.put(num, square);
            return cache.get(square);
        }
    }
}
