public class TestPlayer {
    public static void main(String[] args) {
        Player karaJones = new Player("Kara Jones", 0);
        System.out.println("Created Player -> " + karaJones);

        karaJones.updateScore(6);
        System.out.println("After scoring 6 points -> " + karaJones);

        Player bobSmith = new Player("Bob Smith", 27);
        System.out.println("Created Player -> " + bobSmith);

        bobSmith.updateScore(65);
        System.out.println("After scoring 65 points -> " + bobSmith);
    }
}
