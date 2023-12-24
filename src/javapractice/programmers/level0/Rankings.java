package javapractice.programmers.level0;

import java.util.*;

// 등수 매기기
public class Rankings {
    public int[] solution(int[][] score) {
        double[] avgList = new double[score.length];
        for (int i = 0; i < score.length; i++){
           double avg = ((double) score[i][0] + score[i][1]) / 2.0;
           avgList[i] = avg;
        }
        double[] reverseAvg = avgList.clone();
        Arrays.sort(reverseAvg);
        int rank = 1, index = 0;
        int[] ranking = new int[reverseAvg.length];
        double[] orderedAvg = new double[reverseAvg.length];
        for (int i = reverseAvg.length - 1; i >= 0; i--, index++, rank++){
            orderedAvg[index] = reverseAvg[i];
            if (i != reverseAvg.length - 1 && reverseAvg[i] == reverseAvg[i+1]){
                ranking[index] = ranking[index-1];
            } else {
                ranking[index] = rank;
            }
        }
        List<Integer> rankList = new ArrayList<>();
        for (int i = 0; i < avgList.length; i++){
            for (int j = 0; j < reverseAvg.length; j++){
                if (avgList[i] == orderedAvg[j]){
                    rankList.add(ranking[j]);
                    break;
                }
            }
        }
        int[] answer = new int[score.length];
        for (int i = 0; i < answer.length; i++){
            answer[i] = rankList.get(i);
        }
        return answer;
    }
}
// 등수 매기기
// 문제 설명
// 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다. 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때, 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.
//
// 제한사항
// 0 ≤ score[0], score[1] ≤ 100
// 1 ≤ score의 길이 ≤ 10
// score의 원소 길이는 2입니다.
// score는 중복된 원소를 갖지 않습니다.
//
// 입출력 예
// score	                                                                    result
// [[80, 70], [90, 50], [40, 70], [50, 80]]	                                    [1, 2, 4, 3]
// [[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]	[4, 4, 6, 2, 2, 1, 7]
//
// 입출력 예 설명
// 입출력 예 #1
// 평균은 각각 75, 70, 55, 65 이므로 등수를 매겨 [1, 2, 4, 3]을 return합니다.
//
// 입출력 예 #2
// 평균은 각각 75, 75, 40, 95, 95, 100, 20 이므로 [4, 4, 6, 2, 2, 1, 7] 을 return합니다.
// 공동 2등이 두 명, 공동 4등이 2명 이므로 3등과 5등은 없습니다.