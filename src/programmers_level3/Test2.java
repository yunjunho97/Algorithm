package programmers_level3;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        int coin = 4;
        int[] cards = {3, 6, 7, 2, 1, 10, 11, 9, 4, 12, 5, 8};
        System.out.println(solution(coin, cards));
    }

    public static int solution(int coin, int[] cards){
        ArrayList<Integer> initList = new ArrayList<>();
        int startingCardsNum = cards.length / 3;
        int pointer = 0;
        int targetValue = cards.length + 1;
        int ableRound = 1;
        int nowRound = 0;
        for(; pointer < startingCardsNum; pointer++){
            int pick = cards[pointer];
            if(initList.contains(targetValue - pick)){
                initList.remove(Integer.valueOf(targetValue - pick));
                ableRound++;
            } else {
                initList.add(pick);
            }
        }

        ArrayList<Integer> handList = new ArrayList<>();
        int readySet = 0;
        while(nowRound != ableRound && pointer < cards.length){
            for(int i = 0; i < 2; i++){
                int pick = cards[pointer++];
                if(initList.contains(targetValue - pick) && coin >= 1) {
                    initList.remove(Integer.valueOf(targetValue - pick));
                    coin--;
                    ableRound++;
                } else if(handList.contains(targetValue - pick)){
                    handList.remove(Integer.valueOf(targetValue - pick));
                    readySet++;
                } else {
                    handList.add(pick);
                }
            }
            nowRound++;
            if(nowRound == ableRound && readySet > 0 && coin >= 2) {
                readySet--;
                ableRound++;
                coin -= 2;
            }
        }
        return ableRound;
    }
}
