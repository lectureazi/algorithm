package c_datastructure.map;

import c_datastructure.dto.School;

import java.util.HashMap;

public class Run {

    public static void main(String[] args) {
        School seoulUniv = new School("서울대", "관악구", 4);
        School yunsae = new School("연세대", "신촌", 4);
        School minsa = new School("민사고", "대전", 3);
        School multicampus = new School("멀티캠퍼스", "삼성", 2);
        School semyeong = new School("세명초", "머리", 1);

        _HashMap<String, School> schoolMap = new _HashMap<String, School>();
        schoolMap.put("서울대", seoulUniv);
        schoolMap.put("연세대", yunsae);
        schoolMap.put("민사고", minsa);
        schoolMap.put("멀캠", multicampus);
        schoolMap.put("세명초", semyeong);

        // 중복된 키로 데이터를 저장.
        // 기존 데이터를 덮어씀
        schoolMap.put("서울대", new School("서울대 지방캠", "세종시", 4));

        for (Entry<String, School> entry : schoolMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("=============remove==============");

        schoolMap.remove("민사고");
        schoolMap.remove("멀캠");
        schoolMap.remove("세명초");

        for (Entry<String, School> entry : schoolMap.entrySet()) {
            System.out.println(entry);
        }

    }
}
