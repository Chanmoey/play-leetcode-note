import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        Arrays.sort(str);
        for (String s : str){
            System.out.println(s);
        }
    }
}
