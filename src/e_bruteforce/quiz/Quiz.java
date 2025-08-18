package e_bruteforce.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {

    public static void main(String[] args) {
        q1(5);
        q2();
    }


    static void q1(int n){
        List<Integer> dooms = new ArrayList<>();
        for(int dom=666, cnt=0; cnt < n; dom++){
            if(String.valueOf(dom).contains("666")){
                dooms.add(dom);
                cnt++;
            }
        }

        System.out.println(dooms);
        System.out.println(dooms.getLast());
    }

    static void q2(){
        // 입력값, 아홉난쟁이 키
        List<Integer> dwarfs = nineDwarfs();

        int sum = 0;
        for(int num : dwarfs){
            sum += num;
        }

        int diff = sum - 100;

        for (int i = 0; i < dwarfs.size()-1; i++) {
            for (int j = 1; j < dwarfs.size(); j++) {
                if(diff == dwarfs.get(j) + dwarfs.get(i)){
                    dwarfs.remove(dwarfs.get(j));
                    dwarfs.remove(dwarfs.get(i));
                    break;
                }
            }
        }

        System.out.println(dwarfs);
    }

    private static List<Integer> nineDwarfs() {
        List<Integer> dwarfs = new ArrayList<>();
        Random random = new Random();
        int sum = 0;

        for(int i = 0; i < 6; i++){
            int n = random.nextInt(12, 14);
            sum += n;
            dwarfs.add(n);
        }

        dwarfs.add(100 - sum);
        dwarfs.add(random.nextInt(10, 15));
        dwarfs.add(random.nextInt(10, 15));
        return dwarfs;
    }
}
