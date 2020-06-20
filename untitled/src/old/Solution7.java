package old;

import java.util.ArrayList;
import java.util.Scanner;

class Solution7 {
    static Player2[] winners;
    static Player2[] players;
    static Player2[] winners1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        players = new Player2[n];
        winners = new Player2[players.length / 2];
        for (int i = 0; i < n; i++) {
            int numPlayer = in.nextInt();
            String signPlayer = in.next();
            Player2 player = new Player2(numPlayer, signPlayer);
            players[i] = player;
        }
        int k = 1, q = 0, o = 0, y = 0;
        Player2[] p = new Player2[2];
        int[] winnerAndLooser = new int[2];
        int[][] winAndLoos = new int[n - 1][2];
        ArrayList<Integer> looses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Player2 player = new Player2(players[i].getNumPlayer(), players[i].getSignPlayer());
            p[q] = player;
            q++;
            if (i == k) {
                Player2 r = getWinnerAndLooser(p);
                winnerAndLooser[0] = r.getNumPlayer();
                winnerAndLooser[1] = r.getLooser();
                winAndLoos[y] = winnerAndLooser;
                winnerAndLooser = new int[2];
                y++;
                winners[o] = r;
                ++o;
                q = 0;
                k += 2;
                p = new Player2[2];
            }
            if (i == n - 1) {
                n /= 2;
                players = new Player2[winners.length];
                players = winners;
                winners = new Player2[winners.length / 2];
                k = 1;
                i = -1;
                o = 0;
            }
            if (n == 1) {
                int a = winAndLoos[winAndLoos.length - 1][0];
                for (int l = 0; l < winAndLoos.length; l++) {
                    if (a == winAndLoos[l][0]) {
                        looses.add(winAndLoos[l][1]);
                    }
                }
                System.out.println(a);
                StringBuilder z = new StringBuilder();
                for (int j = 0; j < looses.size(); j++) {
                    if (j == looses.size() - 1) {
                        z.append(looses.get(j));
                    } else {
                        z.append(looses.get(j)).append(" ");
                    }
                }
                System.out.println(z);
            }
        }
    }

    public static Player2 getWinnerAndLooser(Player2[] players) {
        if (players[0].getSignPlayer().equals("C") && players[1].getSignPlayer().equals("P")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("P") && players[1].getSignPlayer().equals("C")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("P") && players[1].getSignPlayer().equals("R")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("R") && players[1].getSignPlayer().equals("P")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("R") && players[1].getSignPlayer().equals("L")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("L") && players[1].getSignPlayer().equals("R")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("L") && players[1].getSignPlayer().equals("S")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("S") && players[1].getSignPlayer().equals("L")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("S") && players[1].getSignPlayer().equals("C")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("C") && players[1].getSignPlayer().equals("S")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("C") && players[1].getSignPlayer().equals("L")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("L") && players[1].getSignPlayer().equals("C")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("L") && players[1].getSignPlayer().equals("P")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("P") && players[1].getSignPlayer().equals("L")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("P") && players[1].getSignPlayer().equals("S")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("S") && players[1].getSignPlayer().equals("P")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("S") && players[1].getSignPlayer().equals("R")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("R") && players[1].getSignPlayer().equals("S")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals("R") && players[1].getSignPlayer().equals("C")) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals("C") && players[1].getSignPlayer().equals("R")) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        if (players[0].getSignPlayer().equals(players[1].getSignPlayer()) &&
                players[0].getNumPlayer() < players[1].getNumPlayer()) {
            players[0].setLooser(players[1].getNumPlayer());
            return players[0];
        } else if (players[0].getSignPlayer().equals(players[1].getSignPlayer()) &&
                players[0].getNumPlayer() > players[1].getNumPlayer()) {
            players[1].setLooser(players[0].getNumPlayer());
            return players[1];
        }
        return players[1];
    }
}

class Player2 {
    private int numPlayer;
    private int looser;
    private String signPlayer;

    public Player2(int numPlayer, String signPlayer) {
        this.numPlayer = numPlayer;
        this.signPlayer = signPlayer;
    }

    public int getNumPlayer() {
        return numPlayer;
    }

    public String getSignPlayer() {
        return signPlayer;
    }

    public int getLooser() {
        return looser;
    }

    public void setLooser(int looser) {
        this.looser = looser;
    }
}