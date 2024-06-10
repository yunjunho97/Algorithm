package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test8 {
    public static void main(String[] args) {
        System.out.println(solution2(3, 2, new int[]{2, 4}, new int[]{4, 2}));

    }

    public static long solution2(int cap, int n, int[] deliveries, int[] pickups){
        int pointD = n-1;
        int pointP = n-1;

        //배달, 수거 총량
        int sumD = Arrays.stream(deliveries).sum();
        int sumP = Arrays.stream(pickups).sum();

        long distance = 0;

        //배달과 수거를 모두 다 할때까지
        while(sumD != 0 || sumP != 0){
            int tempD = 0; //한 사이클을 위한 배달 수량
            int tempP = 0; //한 사이클을 위한 수거 수량

            //창고로부터 가장 먼 배달, 수거 지점 초기화
            for(; pointD >= 0; pointD--){
                if(deliveries[pointD] != 0){
                    break;
                }
            }
            for(; pointP >= 0; pointP--){
                if(pickups[pointP] != 0){
                    break;
                }
            }

            //배달과 수거중 더 먼곳까지 가야하기때문에 더 먼곳 * 2가 이번사이클에서 가야할 거리
            distance += ((long)Math.max(pointD, pointP) + 1) * 2;

            //배달과 수거 작업
            while(tempD < cap && pointD >= 0){
                tempD += deliveries[pointD];
                deliveries[pointD] = 0;
                if(tempD > cap){
                    deliveries[pointD] += (tempD - cap);
                    tempD = cap;
                    break;
                }
                pointD--;
            }
            while(tempP < cap && pointP >= 0){
                tempP += pickups[pointP];
                pickups[pointP] = 0;
                if(tempP > cap){
                    pickups[pointP] += (tempP - cap);
                    tempP = cap;
                    break;
                }
                pointP--;
            }

            //남은 배달과 수거의 개수 갱신
            sumD -= tempD;
            sumP -= tempP;
        }
        return distance;
    }
}
