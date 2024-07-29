package programmers;

public class Test68 {
    public static void main(String[] args) {
        String m = "ABC#";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos){
        m = m.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b")
                .replaceAll("E#", "e");
        String answer = "(None)";
        int timeTemp = 0;

        for(String info : musicinfos){
            String[] infoArr = info.split(",");
//            int times = Integer.parseInt(infoArr[1].split(":")[1]) - Integer.parseInt(infoArr[0].split(":")[1]);
            int times = (Integer.valueOf(infoArr[1].substring(0,2)) * 60 +  // 시간 구하기
                    Integer.valueOf(infoArr[1].substring(3,5))) -
                    (Integer.valueOf(infoArr[0].substring(0,2)) * 60 +
                            Integer.valueOf(infoArr[0].substring(3,5)));
            String music = infoArr[3].replaceAll("C#", "c")
                    .replaceAll("D#", "d")
                    .replaceAll("F#", "f")
                    .replaceAll("G#", "g")
                    .replaceAll("A#", "a")
                    .replaceAll("B#", "b")
                    .replaceAll("E#", "e");
            StringBuilder line = new StringBuilder();
            for(int i = 0; i < times; i++){
                line.append(music.charAt(i % music.length()));
            }

            if(line.toString().contains(m)){
                if(times > timeTemp) {
                    answer = infoArr[2];
                    timeTemp = times;
                }
            }
        }
        return answer;
    }
}
