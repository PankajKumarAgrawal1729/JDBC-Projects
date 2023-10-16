public class ScoreBoard {
    private int id;
    private String name;
    private int runs;
    private int balls;
    private int year;

    public ScoreBoard(int id, String name, int runs, int balls, int year) {
        this.id = id;
        this.name = name;
        this.runs = runs;
        this.balls = balls;
        this.year = year;
    }

    public ScoreBoard(String name, int runs, int balls, int year) {
        this.name = name;
        this.runs = runs;
        this.balls = balls;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
