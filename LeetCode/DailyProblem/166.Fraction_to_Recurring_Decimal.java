// Topics: Hash Table , Math, String

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder ans = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            ans.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long res = num / den;
        ans.append(res);

        long rem = num % den;
        if (rem == 0) return ans.toString();

        ans.append(".");
        Map<Long, Integer> track = new HashMap<>();

        while (rem != 0) {
            if (track.containsKey(rem)) {
                ans.insert(track.get(rem), "(");
                ans.append(")");
                break;
            }
            track.put(rem, ans.length());
            rem *= 10;
            ans.append(rem / den);
            rem %= den;
        }
        return ans.toString();
    }
}

// Time Complesity: O(denominator + length);
// Auxiliary Space: O(denominator); 
