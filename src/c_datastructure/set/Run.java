package c_datastructure.set;

import c_datastructure.dto.School;

public class Run {

    public static void main(String[] args) {
        testSetP1();
    }


    static void testSetP1(){
        School seoulUniv = new School("서울대", "관악구 12-길 나동 101호", 4);
        School yunsae = new School("연세대", "신촌", 4);
        School minsa = new School("민사고", "대전", 3);
        School multicampus = new School("멀티캠퍼스", "삼성", 2);
        School semyeong = new School("세명초", "머리", 1);

        _HashSet_P2<School> set = new _HashSet_P2<>();
        set.add(seoulUniv);
        set.add(yunsae);
        set.add(minsa);
        set.add(multicampus);
        set.add(semyeong);

        // School의 이름과 레벨이 같으면 같은 객체로 판단할 수 있도록 equals와 hashCode를 override 해주세요.
        set.add(new School("서울대", "관악구 12-길 나동 301호", 4));

        System.out.println(set);
        set.remove(seoulUniv);
        System.out.println(set);
        
//        for (School school : set){
//            System.out.println(school);
//        }

    }







}
