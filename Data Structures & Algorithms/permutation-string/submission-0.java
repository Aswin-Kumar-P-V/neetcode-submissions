class Solution {
     public boolean checkInclusion(String s1, String s2) {
        // If s1 is longer than s2, it's impossible for s2 to contain a permutation of s1.
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1Map stores the required character frequencies for s1.
        // s2Map stores the character frequencies for the current sliding window in s2.
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        // 1. Initialize s1Map and the first window of s2Map.
        // The initial window in s2 has the same length as s1.
        for (int i = 0; i < s1.length(); i++) {
            char charS1 = s1.charAt(i);
            char charS2 = s2.charAt(i);
            s1Map.put(charS1, s1Map.getOrDefault(charS1, 0) + 1);
            s2Map.put(charS2, s2Map.getOrDefault(charS2, 0) + 1);
        }

        // 2. Initialize 'matches' count.
        // 'matches' will count how many unique characters in s1Map have their frequencies
        // perfectly matched in s2Map for the current window.
        // If 'matches' equals s1Map.size(), it means all characters required by s1
        // are present in the current s2 window with the correct frequencies.
        int matches = 0;
        for (char c : s1Map.keySet()) {
            if (s1Map.get(c).equals(s2Map.getOrDefault(c, 0))) {
                matches++;
            }
        }

        // 3. Slide the window across s2.
        // 'l' is the left pointer, 'r' is the right pointer.
        // The loop for 'r' starts from s1.length() because the first window (0 to s1.length()-1)
        // has already been processed.
        int l = 0; // Left pointer of the sliding window
        for (int r = s1.length(); r < s2.length(); r++) {
            // If all unique characters in s1 have matching counts, we found a permutation.
            if (matches == s1Map.size()) {
                return true;
            }

            // --- Process character entering the window (at 'r') ---
            char charToAdd = s2.charAt(r);
            
            // Only update 'matches' if the character is relevant to s1 (i.e., present in s1Map).
            if (s1Map.containsKey(charToAdd)) {
                int s1CountVal = s1Map.get(charToAdd);
                int s2OldCountVal = s2Map.getOrDefault(charToAdd, 0);

                // If frequencies were equal before adding this char, they won't be equal after, so decrement matches.
                if (s1CountVal == s2OldCountVal) {
                    matches--;
                }
            }
            // Increment count for charToAdd in s2Map.
            s2Map.put(charToAdd, s2Map.getOrDefault(charToAdd, 0) + 1);
            
            // Check if frequencies are now equal after adding, if so, increment matches.
            if (s1Map.containsKey(charToAdd)) {
                int s1CountVal = s1Map.get(charToAdd);
                int s2NewCountVal = s2Map.get(charToAdd);
                if (s1CountVal == s2NewCountVal) {
                    matches++;
                }
            }


            // --- Process character leaving the window (at 'l') ---
            char charToRemove = s2.charAt(l);

            // Only update 'matches' if the character is relevant to s1.
            if (s1Map.containsKey(charToRemove)) {
                int s1CountVal = s1Map.get(charToRemove);
                int s2OldCountVal = s2Map.getOrDefault(charToRemove, 0);

                // If frequencies were equal before removing this char, they won't be equal after, so decrement matches.
                if (s1CountVal == s2OldCountVal) {
                    matches--;
                }
            }
            // Decrement count for charToRemove in s2Map.
            s2Map.put(charToRemove, s2Map.getOrDefault(charToRemove, 0) - 1);
            
            // Check if frequencies are now equal after removing, if so, increment matches.
            if (s1Map.containsKey(charToRemove)) {
                int s1CountVal = s1Map.get(charToRemove);
                int s2NewCountVal = s2Map.get(charToRemove);
                if (s1CountVal == s2NewCountVal) {
                    matches++;
                }
            }
            
            // Move the left pointer forward to shrink the window.
            l++;
        }

        // 4. After the loop, check the last window.
        return matches == s1Map.size();
    }
}
