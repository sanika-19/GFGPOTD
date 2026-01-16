class Day16_MinimumWorker {
    public int minMen(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        // currentEnd: how far we have covered the day so far
        // farthest: how far we can potentially cover by picking one more person
        int count = 0;
        int currentEnd = -1; 
        int farthest = -1;
        int i = 0;

        // Loop until the entire range [0, n-1] is covered
        while (currentEnd < n - 1) {
            boolean increased = false;

            // Check all people available up to the current coverage limit + 1
            // (Since we need to cover the very next unit of time)
            while (i < n) {
                if (arr[i] != -1) {
                    int left = Math.max(0, i - arr[i]);
                    int right = i + arr[i];

                    // If this person can start from where we left off
                    if (left <= currentEnd + 1) {
                        if (right > farthest) {
                            farthest = right;
                            increased = true;
                        }
                    } else {
                        // People are checked in order of index i. 
                        // However, left bounds aren't strictly sorted, so we 
                        // continue checking others if this specific person starts too late.
                        // Optimization: For larger constraints, sorting by left bound is better.
                    }
                }
                i++;
            }

            // If we didn't find anyone who could extend the reach, it's impossible
            if (farthest <= currentEnd) {
                return -1;
            }

            // Greedily pick the person who extends the reach the most
            currentEnd = farthest;
            count++;

            // If we've covered the whole range, break early
            if (currentEnd >= n - 1) break;
            
            // Reset i for the next "jump" to check all people again 
            // who might start within the new currentEnd.
            i = 0; 
        }

        return count;
    }
}