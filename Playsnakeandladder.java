package snakesandladders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Playsnakeandladder {
    public static void main(String args[]) {
        Dice dice = new Dice(1);
        Player p1 = new Player("Ram");
        Player p2 = new Player("Subba Rao");
        Player p3 = new Player("Sesha sai");
        Player p4 = new Player("Revanth");
        Queue<Player> nextPlayer = new LinkedList<>();
        nextPlayer.offer(p1);
        nextPlayer.offer(p2);
        nextPlayer.offer(p3);
        nextPlayer.offer(p4);
        Jumper j1 = new Jumper(20, 2);
        Jumper j2 = new Jumper(56, 7);
        Jumper j3 = new Jumper(99, 15);
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(j1);
        snakes.add(j2);
        snakes.add(j3);
        Jumper l1 = new Jumper(5, 60);
        Jumper l2 = new Jumper(28, 74);
        Jumper l3 = new Jumper(44, 97);
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(l1);
        ladders.add(l2);
        ladders.add(l3);
        Map<String, Integer> playerCurrentPosition = new HashMap<>();
        playerCurrentPosition.put("Ram", 0);
        playerCurrentPosition.put("Subba Rao", 0);
        playerCurrentPosition.put("Sesha sai", 0);
        playerCurrentPosition.put("Revanth", 0);
        DesignofGameBoard gb = new DesignofGameBoard(dice, nextPlayer, snakes, ladders, playerCurrentPosition, 100);
        gb.startGame();

    }
}
