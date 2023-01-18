import java.io.*;

public class B1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        int answer = 0;
        for (int i=0; i < arr.length; i++) {
            int sumV = 0;
            String[] cal = arr[i].split("\\+");

            for (int j = 0; j < cal.length; j++) {
                sumV += Integer.parseInt(cal[j]);
            }
            if (i == 0) {
                answer += sumV;
            }else {
                answer -= sumV;
            }
        }
        System.out.println(answer);
    }
}
