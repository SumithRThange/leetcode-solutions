class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ans = new ArrayList<>();
        int n = bulbs.size();
        Map<Integer, Integer> bulb = new HashMap<>();
        for(int i=0;i<n;i++){
            if(bulb.containsKey(bulbs.get(i))){
                bulb.put(bulbs.get(i), bulb.get(bulbs.get(i)) ^ 1);
            } else {
                bulb.put(bulbs.get(i), 1);
            }
        }
        for(int i=0;i<n;i++){
            if(bulb.get(bulbs.get(i)) == 1){
                if(!ans.contains(bulbs.get(i)))
                ans.add(bulbs.get(i));
            }
        }
         Collections.sort(ans);
         return ans;
    }
}