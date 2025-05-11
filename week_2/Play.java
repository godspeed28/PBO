public class Play {
    public static void main(String[] args) {
        Character player1 = new Character();
        player1.setData("Cloud");
        System.out.println("Character Baru: ");
        System.out.println("Nama : " + player1.nama);
        System.out.println("HP: " + player1.getHp());
        System.out.println("Level " + player1.getLevel());

        if (player1.getHp() == 0) {
            System.out.println(player1.nama + " mati");
        } else {
            player1.attack();
            player1.attack();
            player1.attack();
            player1.attack();
            player1.attack();
            player1.attack();
            player1.attack();
            player1.attack();
            player1.attack();
            player1.attack();
            if (player1.getExp() == 10) {
                player1.levelUp();
            }
        }
    }
}
