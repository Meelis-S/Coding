import java.util.Random;

public class Haiku {
    public static void main(String[] args) {
        String[] a = {"fall", "woman", "sad", "water", "plays", "sun", "fox", "laughs", "stone", "to", "eternally", "fog", "flys", "star"};
        
        Random rand = new Random();


        for (int i = 1; i <= 3; i++) {
            int rand_llength = rand.nextInt(4) + 1;
            String row = "";
            int j = 1;

            do {
                int elemno = rand.nextInt(13);
                row = row + " " + a[elemno];
                j++;
            } while (j <= rand_llength);
            System.out.println(row);
        }
    }
}
