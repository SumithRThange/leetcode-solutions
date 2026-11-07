
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] result = new int[m];

        // Available servers: weight, index
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                ? a[0] - b[0]
                : a[1] - b[1]
        );

        // Busy servers: finishTime, weight, index
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]);
                if (a[1] != b[1])
                    return Long.compare(a[1], b[1]);
                return Long.compare(a[2], b[2]);
            }
        );

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long currentTime = 0;

        for (int i = 0; i < m; i++) {

            currentTime = Math.max(currentTime, i);

            // Release all servers that have finished
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= currentTime) {

                long[] s = busy.poll();

                available.offer(new int[]{
                    (int) s[1],
                    (int) s[2]
                });
            }

            // If no server is available, advance time
            if (available.isEmpty()) {

                currentTime = busy.peek()[0];

                // Release all servers finishing at this time
                while (!busy.isEmpty() &&
                       busy.peek()[0] == currentTime) {

                    long[] s = busy.poll();

                    available.offer(new int[]{
                        (int) s[1],
                        (int) s[2]
                    });
                }
            }

            // Select server with minimum weight, then index
            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            result[i] = index;

            // Assign task and calculate finishing time
            busy.offer(new long[]{
                currentTime + tasks[i],
                weight,
                index
            });
        }

        return result;
    }
}
