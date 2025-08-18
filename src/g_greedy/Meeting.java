package g_greedy;

public class Meeting implements Comparable<Meeting> {

    private String team;
    private int start;
    private int end;

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

    @Override
    public int compareTo(Meeting o) {
        return end - o.end;
    }
}