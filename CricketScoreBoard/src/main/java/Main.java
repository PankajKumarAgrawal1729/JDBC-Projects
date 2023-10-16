import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static  Scanner sc = new Scanner(System.in);
    public static  void updateDetail(ScoreBoardDao dao, int choice, int id){
        switch (choice){
            case 1:
                System.out.print("Enter the name of the Player: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Enter the runs of the player: ");
                int runs = sc.nextInt();
                System.out.print("Enter the balls taken by Player: ");
                int balls = sc.nextInt();
                System.out.print("Enter the year: ");
                int year = sc.nextInt();
                ScoreBoard scoreDetail = new ScoreBoard(name, runs, balls, year);
                if(dao.updateWholeData(scoreDetail, id)){
                    System.out.println("Details Updated Successfully!");
                } else {
                    System.out.println("Something went wrong!!");
                }
                break;
            case 2:
                System.out.print("Enter the name of the Player: ");
                sc.nextLine();
                name = sc.nextLine();
                if(dao.updateName(name, id)){
                    System.out.println("Name Updated Successfully!");
                } else {
                    System.out.println("Something went wrong!!");
                }
                break;
            case 3:
                System.out.print("Enter the runs of the player: ");
                runs = sc.nextInt();
                if(dao.updateRuns(runs, id)){
                    System.out.println("Runs Updated Successfully!");
                } else {
                    System.out.println("Something went wrong!!");
                }
                break;
            case 4:
                System.out.print("Enter the balls taken by Player: ");
                balls = sc.nextInt();
                if(dao.updateBalls(balls, id)){
                    System.out.println("Balls Updated Successfully!");
                } else {
                    System.out.println("Something went wrong!!");
                }
                break;
            case 5:
                System.out.print("Enter the year: ");
                year = sc.nextInt();
                if(dao.updateYear(year, id)){
                    System.out.println("Year Updated Successfully!");
                } else {
                    System.out.println("Something went wrong!!");
                }
                break;
            default:
                System.out.println("No data Updated!!");
                break;
        }
        return;
    }

    public static void main(String[] args) throws Exception{

        ScoreBoardDao dao = new ScoreBoardDao(ConnectionProvider.getConnection());
        boolean flag = true;
        while(flag){
            System.out.println("Enter the Choice: ");
            System.out.println("1. View the Record");
            System.out.println("2. Insert the Record");
            System.out.println("3. Update the Record.");
            System.out.println("4. Delete the Record");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    ArrayList<ScoreBoard> scores = dao.getScoreBoardDetails();
                    if(scores.size() == 0){
                        System.out.println("No Record available.");
                    }else{
                        System.out.println("ScoreCard:");
                        System.out.println("ID\t| Name\t| Runs\t| Balls\t| Year\t");
                        for(ScoreBoard score: scores){
                            System.out.println(score.getId() +"\t| " + score.getName() + "\t| " + score.getRuns() + "\t| " + score.getBalls() + "\t| " + score.getYear() + "\t");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter the name of the Player: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter the runs of the player: ");
                    int runs = sc.nextInt();
                    System.out.print("Enter the balls taken by Player: ");
                    int balls = sc.nextInt();
                    System.out.print("Enter the year: ");
                    int year = sc.nextInt();
                    ScoreBoard scoreDetail = new ScoreBoard(name, runs, balls, year);
                    boolean isInserted = dao.insertScore(scoreDetail);
                    if(isInserted){
                        System.out.println("Player Data Stored Successfully!!");
                    }
                    else {
                        System.out.println("Something went wrong!!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Player id whose data wants to update");
                    int id = sc.nextInt();
                    if(dao.isPlayerPresent(id)){
                        System.out.println("What you want to Update: ");
                        System.out.println("1. Update the Whole Data.\n2. Update the Name of the Player.\n3. Update the Runs of the Player.\n4. Update the Balls of the Player.\n5. Update the Year of the Player.\n6. Nothing to Update");
                        int updateChoice = sc.nextInt();
                        updateDetail(dao, updateChoice, id);
                    }
                    else {
                        System.out.println("Player Not Found.\nPlease Enter the correct id!!");
                    }
                    break;
                case 4:
                    System.out.println("Enter Player id whose data wants to deleted");
                    id = sc.nextInt();
                    if(dao.isPlayerPresent(id)){
                        if(dao.deletePlayerData(id)){
                            System.out.println("Player Deleted Successfully");
                        }
                        else {
                            System.out.println("Something went wrong!!");
                        }
                    }
                    else {
                        System.out.println("Player Not Found.\nPlease Enter the correct id!!");
                    }
                    break;
                default:
                    System.out.println("Thanks for Coming!!");
                    flag = false;
                    break;
            }
        }
    }
}
