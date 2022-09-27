/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer,ArrayList<String>> map = new HashMap<>();
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<strs.length;i++) {
            String str = strs[i];
            int val = 0;
            for(int j=0;j<str.length();j++) {
                val+=str.charAt(j)-'a';
            }
            minVal = Math.min(minVal,val);
            maxVal = Math.max(maxVal,val);
            if(map.containsKey(val)) {
                ArrayList<String> list = map.get(val);
                list.add(strs[i]);
                map.put(val,list);
            } else {
                map.put(val,new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        return new ArrayList<>(map.values());
    }
}