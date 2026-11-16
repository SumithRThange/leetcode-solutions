class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> frequencyMap = new HashMap<>();
        for(String str : strs){
            String frequencyStr = getFrequencyString(str);
            if(frequencyMap.containsKey(frequencyStr)){
                frequencyMap.get(frequencyStr).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyMap.put(frequencyStr, strList);
            }
        }
        return new ArrayList<>(frequencyMap.values());
    }

    private String getFrequencyString (String str){
        int[] freq = new int[26];
        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }
        StringBuilder freqstr = new StringBuilder();
        char c = 'a';
        for(int i : freq){
            freqstr.append(c);
            freqstr.append(i);
            c++;
        }
        return freqstr.toString();
    }
}