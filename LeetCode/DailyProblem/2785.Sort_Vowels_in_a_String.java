// Topics: String, Sorting

class Solution {
    public boolean isVowel(char ch){
        return (ch=='I' ||ch=='O' ||ch=='U' ||ch=='u' ||ch=='o' ||ch=='i' ||ch=='e' ||ch=='a' ||ch=='A' ||ch=='E');
    }
    public String sortVowels(String s) {
        int n = s.length(), m = 0, idx = 0;
        for(int i = 0 ; i < n ; i++) if(isVowel(s.charAt(i))) m++;
        int[] vowels = new int[m];
        int[] indices = new int[m];
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                vowels[idx]=s.charAt(i);
                indices[idx++]=i; 
            }
        }
        idx = 0;
        Arrays.sort(vowels);
        StringBuilder sb = new StringBuilder(s);
        for(int i : indices) sb.setCharAt(i,(char)vowels[idx++]);
        return sb.toString();
    }
}

// Time complexity: O(nlogn);
// Auxiliary Space: O(n);
