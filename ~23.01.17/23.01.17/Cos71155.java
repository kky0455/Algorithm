import java.util.*;
public class Cos71155 {

    class Info{
        int x;
        int y;
        public Info(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public int solution(int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        int n = garden.length;
        Queue<Info> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j =0; j < n; j++) {
                if (garden[i][j] == 1) queue.add(new Info(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = info.y + dy[i];
                int nx = info.x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (garden[ny][nx] == 0) {
                    garden[ny][nx] = garden[info.y][info.x] + 1;
                    queue.add(new Info(ny, nx));
                    answer = Math.max(answer, garden[ny][nx]-1);
                }
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Cos71155 sol = new Cos71155();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }
}
