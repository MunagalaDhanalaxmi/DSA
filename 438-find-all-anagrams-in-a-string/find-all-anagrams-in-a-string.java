import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case
        if (s.length() < p.length()) {
            return result;
        }
        
        int[] pCounts = new int[26];
        int[] sCounts = new int[26];
        
        // Build the frequency profile for p and the first window of s
        for (int i = 0; i < p.length(); i++) {
            pCounts[p.charAt(i) - 'a']++;
            sCounts[s.charAt(i) - 'a']++;
        }
        
        // Check the very first window
        if (matches(pCounts, sCounts)) {
            result.add(0);
        }
        
        // Slide the window across the rest of string s
        for (int i = p.length(); i < s.length(); i++) {
            // Add the incoming character (right side of window)
            sCounts[s.charAt(i) - 'a']++;
            
            // Remove the outgoing character (left side of window)
            sCounts[s.charAt(i - p.length()) - 'a']--;
            
            // If frequencies match, record the start index of this window
            if (matches(pCounts, sCounts)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
    
    // Helper method to compare two frequency arrays of size 26
    private boolean matches(int[] pCounts, int[] sCounts) {
        for (int i = 0; i < 26; i++) {
            if (pCounts[i] != sCounts[i]) {
                return false;
            }
        }
        return true;
    }
}