package inflearn;

import java.util.stream.IntStream;

public class Test51_OptimalCapacity {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6,7,8,9};
        int k = 3;
        solution(list, k);
    }

    //결정 알고리즘
    //정답이 lt 부터 rt사이에 무조건 존재할떄

    //더 좋은 정답이 있는지 찾아나가자

    //dvd의 용량이 될 수 있는 최소값은 list에서 제일 큰 값, 최대값은 list의 총 합
    public static void solution(int[] list, int k){
        int lt = list[list.length-1]; //최소값
        int rt = IntStream.of(list).sum(); //최대값
        int mt = (lt + rt) / 2; //중간값
        int answer = 0;
        while(lt <= rt){
            int i = 0;
            for(int j = 0; j < k; j++){ //DVD의 최대 개수만큼
                int sum = 0; //DVD 한장에 꽉 채워넣어보자
                while(i < list.length){
                    if(sum + list[i] <= mt){ //들어갈수 있으면 넣고
                        sum += list[i];
                        i++;
                    } else { //더이상 못넣으면 다음 DVD로
                        break;
                    }
                }
            }
            if(i < list.length){
                //i값이 리스트의 끝까지 못갔다는건 mt용량인 k개의 DVD로는 모두 담지 못했다는것
                //그러면 현재 mt의 오른쪽 구역에서 다시 찾아야 함
                //fail
                lt = mt + 1;
                mt = (lt + rt) / 2;
            } else {
                //다 담는데 성공했으면 일단 현재 가능한 mt용량을 answer에 저장해두고
                //mt의 왼쪽 구역에서 더 적은 용량으로 가능한지 탐색, 더 좋은 정답이 있는지 찾아나가자
                //만약 현재의 mt가 최소용량이었다면 이후 실행은 모두 fail로 들어가기때문에
                //가장 바깥의 while문이 끝날때까지 이 answer값은 변하지 않는다
                //true
                answer = mt;
                rt = mt - 1;
                mt = (lt + rt) / 2;
            }
        }
        System.out.println(answer);
    }
}
