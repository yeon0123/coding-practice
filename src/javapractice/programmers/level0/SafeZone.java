package javapractice.programmers.level0;

import java.util.ArrayList;
import java.util.List;

// 안전지대
public class SafeZone {
    public int solution(int[][] board) {
        int answer = 0;
        List<String> mineIndex = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == 1){
                    mineIndex.add("" + i + j);
                }
            }
        }
        List<String> dangerZone = new ArrayList<>(mineIndex);
        for (String mine : mineIndex){
            int mineRow = Character.getNumericValue(mine.charAt(0));
            int mineColumn = Character.getNumericValue(mine.charAt(1));
            for (int dr = -1; dr <= 1; dr++){
                for (int dc = -1; dc <= 1; dc++){
                    int newRow = mineRow + dr;
                    int newCol = mineColumn + dc;
                    if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length){
                        dangerZone.add("" + newRow + newCol);
                    }
                }
            }
        }
        int[][] updatedBoard = new int[board.length][board[0].length];
        for (String danger : dangerZone){
            int dangerRow = Character.getNumericValue(danger.charAt(0));
            int dangerColumn = Character.getNumericValue(danger.charAt(1));
            if (dangerRow < updatedBoard.length && dangerColumn < updatedBoard[0].length){
                updatedBoard[dangerRow][dangerColumn] = 1;
            }
        }
        for (int i = 0; i < updatedBoard.length; i++){
            for (int j = 0; j < updatedBoard[i].length; j++){
                if (updatedBoard[i][j] != 1){
                    answer++;
                }
            }
        }
        return answer;
    }
}
// 안전지대
// 문제 설명
// 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
// image.png
// 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
// 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
//
// 제한사항
// board는 n * n 배열입니다.
// 1 ≤ n ≤ 100
// 지뢰는 1로 표시되어 있습니다.
// board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
//
// 입출력 예
// board	                                                                                                                result
// [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	                                16
// [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	                                13
// [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0
//
// 입출력 예 설명
// 입출력 예 #1
// (3, 2)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선 총 8칸은 위험지역입니다. 따라서 16을 return합니다.
//
// 입출력 예 #2
// (3, 2), (3, 3)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선은 위험지역입니다. 따라서 위험지역을 제외한 칸 수 13을 return합니다.
//
// 입출력 예 #3
// 모든 지역에 지뢰가 있으므로 안전지역은 없습니다. 따라서 0을 return합니다.