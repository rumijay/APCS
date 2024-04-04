
import java.lang.Math;

public class Invoke {
    final static double SONG_SIZE = 3.04;
    final static double VIDEO_SIZE = 89.3;
    final static double PHOTO_SIZE = 1.72;
    public static int piggyBank(int pennies, int nickels, int dimes, int quarters, int halfDollars) {

        int worth = (pennies + (nickels*5) + (dimes*10) + (quarters*25) + (halfDollars*50));
        return worth;

    }

   public static int mp3Sizer(int songs, int videos, int photos) {
   double estimate = Math.ceil((((SONG_SIZE*songs) + (VIDEO_SIZE*videos) + (PHOTO_SIZE*photos))/1000));
        

        return (int)(estimate);

    }


}
