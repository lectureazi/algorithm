package f_divideandconcure.quiz;

public class Meeting {

    private final String team;
    private final int start;
    private final int end;

    public Meeting(String team, int start, int end) {
        this.team = team;
        this.start = start;
        this.end = end;
    }

    public String getTeam() {
        return team;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + team + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
