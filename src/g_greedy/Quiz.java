package g_greedy;

import java.util.*;

public class Quiz {
    public static void main(String[] args) {
        q1(3456);
        q2();
    }

    static void q1(int price){
        Map<Integer, Integer> coins = new LinkedHashMap<>();
        coins.put(500, 0);
        coins.put(100, 0);
        coins.put(50, 0);
        coins.put(10, 0);
        coins.put(1, 0);

        for (int coin : coins.keySet()){
            coins.put(coin, price/coin);
            price %= coin;
        }

        for (int coin : coins.keySet()){
            System.out.printf("%d 동전 %d 개 \n", coin, coins.get(coin));
        }
    }

    static void q2(){
        List<Meeting> meetings = createMeetings();
        List<Meeting> timetable = new ArrayList<>();
        Collections.sort(meetings);

        timetable.add(meetings.getFirst());
        meetings.removeFirst();

        for (Meeting meeting : meetings) {
            if(meeting.getStart() >= timetable.getLast().getEnd()){
                timetable.add(meeting);
            }
        }

        System.out.println(timetable);
    }


    private static List<Meeting> createMeetings() {
        List<Meeting> meetings = new ArrayList<Meeting>();
        meetings.add(new Meeting("개발", 1, 10));
        meetings.add(new Meeting("기획", 5, 6));
        meetings.add(new Meeting("인사", 13, 15));
        meetings.add(new Meeting("총무", 14, 17));
        meetings.add(new Meeting("QA", 8, 14));
        meetings.add(new Meeting("CS", 3, 12));
        return meetings;
    }
}
