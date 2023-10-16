import java.sql.*;
import java.util.ArrayList;

public class ScoreBoardDao {
    Connection con;
    public ScoreBoardDao(Connection con){
        this.con = con;
    }
    public ArrayList<ScoreBoard> getScoreBoardDetails(){
        ArrayList<ScoreBoard> scores = new ArrayList<>();
        try {
            //1. database Query
            String query = "Select * from score";
            //2. Create the statement object
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet set = pst.executeQuery();
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                int runs = set.getInt("runs");
                int balls = set.getInt("balls");
                int year = set.getInt("year");
                scores.add(new ScoreBoard(id, name, runs, balls, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public boolean insertScore(ScoreBoard score){
        boolean inserted = false;
        try {
            String query = "Insert INTO score(name, runs, balls, year) VALUES(?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, score.getName());
            pst.setInt(2, score.getRuns());
            pst.setInt(3, score.getBalls());
            pst.setInt(4, score.getYear());
            pst.executeUpdate();
            inserted = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return inserted;
    }

    public boolean updateName(String name, int id){
        boolean updated = false;
        try {
            String query = "UPDATE score set name=? where id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, id);
            pst.executeUpdate();
            updated = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }

    public boolean updateRuns(int runs, int id){
        boolean updated = false;
        try {
            String query = "UPDATE score set runs=? where id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, runs);
            pst.setInt(2, id);
            pst.executeUpdate();
            updated = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }

    public boolean updateBalls(int balls, int id){
        boolean updated = false;
        try {
            String query = "UPDATE score set balls=? where id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, balls);
            pst.setInt(2, id);
            pst.executeUpdate();
            updated = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }

    public boolean updateYear(int year, int id){
        boolean updated = false;
        try {
            String query = "UPDATE score set year=? where id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, year);
            pst.setInt(2, id);
            pst.executeUpdate();
            updated = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }

    public boolean updateWholeData(ScoreBoard score, int id){
        boolean updated = false;
        try {
            String query = "UPDATE score set name=?,runs=?,balls=?,year=? where id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, score.getName());
            pst.setInt(2, score.getRuns());
            pst.setInt(3, score.getBalls());
            pst.setInt(4, score.getYear());
            pst.setInt(5, id);
            pst.executeUpdate();
            updated = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updated;
    }

    public boolean isPlayerPresent(int id){
        boolean present = false;
        try {
            String query = "SELECT * from score where id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet set = pst.executeQuery();
            if(set.next()){
                present = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return present;
    }

    public boolean deletePlayerData(int id){
        boolean deleted = false;
        try {
            String query = "DELETE from score where id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            deleted = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return deleted;
    }

}
