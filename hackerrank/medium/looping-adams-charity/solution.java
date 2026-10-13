import java.io.*;
import java.util.*;

public class Solution {
public static void main(String[] arg){
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextInt()){
        int n = scanner.nextInt();
        long totalCoins =0;
        for (int i=1; i <= n; i++){
            totalCoins += (long) i * i;
        }
        System.out.println(totalCoins);
    }
    scanner.close();
    }
}
