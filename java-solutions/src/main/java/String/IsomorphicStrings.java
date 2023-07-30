package String;

import java.util.HashMap;
import java.util.Map;

/*
Determines if two strings are isomorphic by checking their character mappings.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Character> map1 = new HashMap<>();
        int i = 0;

        while(i < s.length()){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map1.containsKey(c1)){
                if(map1.get(c1) != c2){
                    return false;
                }
            } else if(map1.containsValue(c2)){
                return false;
            } else {
                map1.put(c1,c2);
            }
            i++;
        }
        return true;
    }
}
