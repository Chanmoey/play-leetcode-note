package LeetCode1286;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanmory
 * @date 2021年11月14日 9:46
 * @description LeetCode第1286题
 */
class CombinationIterator {

        private List<String> list;

        public CombinationIterator(String characters, int combinationLength) {
            this.list = new ArrayList<>();
            List<Character> charList = new ArrayList<>();
            backtrack(characters,0, combinationLength, charList);
        }

        public String next() {

            String next = this.list.get(0);
            this.list.remove(0);
            return next;


        }

        public boolean hasNext() {
            return this.list.size() > 0;
        }


        public void backtrack(String characters,int start, int length, List<Character> chars){

            if(chars.size() == length){
                StringBuilder sb =new StringBuilder();
                for(char c: chars){
                    sb.append(c);
                }
                this.list.add(sb.toString());
            }

            for(int i = start; i<characters.length();i++){
                chars.add(characters.charAt(i));
                backtrack(characters, i+1,length, chars);
                chars.remove(chars.size()-1);
            }
        }
}
