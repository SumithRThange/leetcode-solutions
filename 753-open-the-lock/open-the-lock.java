class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>(Arrays.asList(deadends));
        if(seen.contains("0000"))
        return -1;
        Deque<String>  q = new ArrayDeque<>();
        q.add("0000");
        seen.add("0000");
        for(int steps=0;!q.isEmpty();steps++){
            for(int s=q.size();s>0;s--){
                String cur = q.poll();
                if(cur.equals(target))
                return steps;
                for(int i=0;i<4;i++){
                    for(int d: new int[] {1, 9}){
                        char[] c = cur.toCharArray();
                        c[i] = (char) ('0' + (c[i] - '0' + d) % 10);
                        String nx = new String(c);
                        if(seen.add(nx)) q.add(nx);
                    }
                }
            }
        }
        return -1;
    }
}