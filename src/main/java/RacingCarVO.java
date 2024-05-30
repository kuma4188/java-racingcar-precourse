import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RacingCarVO {
    private int try_num;
    private String[] cars;
    Map<String , Integer> race = new HashMap<>();


    public RacingCarVO() {
        this.try_num = 0;
    }// constructor


    public RacingCarVO(int try_num) {
        this.try_num = try_num;
    }// constructor overloading


    public void GetCar() {
        int tri = 0;
        String input;
        do {
            tri = 0;
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            cars = input.split(",");
            for (String car : cars) {
                tri += FindError(car);
            }
        } while (tri != 0);
    }// get carname


    public void AddCar() {
        for (String car : cars) {
            race.put(car,0);
        }
    } //get a carname


    public int FindError(String car) {
        try {
            if (car.length() > 5) {
                throw new IllegalArgumentException("car name must be less than 5 characters!");
            }
            return 0; // 올바른 입력이 들어올때
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] : %s is more than 5 characters!\n" , car);
        }
        return 1;
    } // find error.


    public void Go(){
        for (String car : cars){
            int distance = race.get(car);
            distance += GoOrStop();
            race.put(car , distance);
        }
    }// Go and Stop and calculate distance

    public int GoOrStop() {
        Random rand = new Random();
        int tmp = rand.nextInt(10);
        if (tmp >=4) {
            return 1;
        }
        return 0;
    }// if tmp is more than 4 , go one step or stop


    public void PrintCar(){
        for (String car : cars ){
            System.out.println(car + " " + race.get(car));
        }
    }// print all cars



}
