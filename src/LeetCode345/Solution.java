package LeetCode345;

class Solution {
    /*public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char temp;
        StringBuilder sb = new StringBuilder(s);
        while (i < j){
            if(!isVowel(sb.charAt(i))){
                i++;
            }
            else if(!isVowel(sb.charAt(j))){
                j--;
            }else if(isVowel(sb.charAt(i)) && isVowel(sb.charAt(j))){
                temp = sb.charAt(i);
                sb.replace(i++, i+1, ;
            }
        }
    }*/

    /*public String reverseVowels(String s){
        char[] cVowels = new char[s.length()];
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                cVowels[index++] = s.charAt(i);
            }
        }

        int j = index - 1;
        int i = 0;
        char temp;
        while (i < j){
            temp = cVowels[i];
            cVowels[i++] = cVowels[j];
            cVowels[j--] = temp;
        }

        char[] sb = s.toCharArray();
        j = 0;
        for(i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                sb[i] = cVowels[j++];
            }
        }

        String ss = new String(sb);
        return ss;
    }*/

    public String reverseVowels(String s){

        if (s.isEmpty())
            return s;

        char[] cs = s.toCharArray();
        int low = 0, high = s.length();
        while (low < high){
            while (!isVowel(cs[low]) && low < high){
                low ++;
            }
            while (!isVowel(cs[high]) && low < high){
                high --;
            }
            if(low < high){
                char temp = cs[low];
                cs[low++] = cs[high--];
                cs[high--] = temp;
            }
        }

        return new String(cs);
    }

    public static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}