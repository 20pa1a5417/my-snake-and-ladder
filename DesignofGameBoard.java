package snakesandladders;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DesignofGameBoard {
    private Dice dice;
    private Queue<Player> nextPlayer;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Map<String, Integer> playerCurrentPosition;
    int boardsize;

    public DesignofGameBoard(Dice dice, Queue<Player> nextPlayer, List<Jumper> snakes, List<Jumper> ladders,
            Map<String, Integer> playerCurrentPosition, int boardsize) {
        this.dice = dice;
        this.nextPlayer = nextPlayer;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardsize = boardsize;
    }

    public void startGame() {
        while (nextPlayer.size() > 1) {
            Player player = nextPlayer.poll();
            int currentPosition = playerCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDiceNo();
            int nextcell = currentPosition + diceValue;
            if (nextcell > boardsize) {
                nextPlayer.offer(player);
            } else if (nextcell == boardsize) {
                System.out.println(player.getPlayerName() + " " + "won the game");
            } else {
                int[] nextPosition = new int[1];
                boolean[] b = new boolean[1];
                nextPosition[0] = nextcell;
                snakes.forEach(v -> {
                    if (v.startpoint == nextcell) {
                        nextPosition[0] = v.endpoint;
                    }
                });
                if (nextPosition[0] != nextcell) {
                    System.out.println(player.getPlayerName() + " " + "Bitten by a snake present at" + " " + nextcell);
                }
                ladders.forEach(v -> {
                    if (v.startpoint == nextcell) {
                        nextPosition[0] = v.endpoint;
                        b[0] = true;
                    }
                });

                if (nextPosition[0] != nextcell && b[0]) {
                    System.out.println(player.getPlayerName() + " " + "Got ladder present at" + " " + nextcell);
                }
                if (nextPosition[0] == boardsize) {
                    System.out.println(player.getPlayerName() + " " + "won the game");
                } else {
                    playerCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
                    System.out.println(player.getPlayerName() + " " + "is at position" + " " + nextPosition[0]);
                    nextPlayer.offer(player);
                }
            }
        }
    }
}