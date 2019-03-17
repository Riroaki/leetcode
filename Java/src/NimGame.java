public class NimGame {
    // A brain teaser game.
        // rule: 2 players, anyone can take 1~3 from n
        // the one who take last number is the winner.

        // Actually, after a take i = 1, 2, 3, you can just take 4 - i
        // And at last there will be 4 stones, so the player will win.

      // however, if the stone is 4 before playing, the first one loses.
      // so if n is divisible by 4, the first one loses.
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
