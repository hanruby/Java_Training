package ch16.ex16_11;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    
    private int score;

    public Game() {
        // TODO Auto-generated constructor stub
    }
    
    public static void main(String[] args) {

        Queue<String> names = new LinkedList<String>() { 
            private static final long serialVersionUID = 2018587615929817842L;
            {
                add("ch16.ex16_11.RandomPlayer");
            }
        };
        
        String name;    // class name
        
        // TODO: サーバ化 P.382
        while ((name = names.poll()) != null) {
            try {
                // ゲームを実行するためのクラスをロードするためにPlayerLoaderオブジェクトを生成
                PlayerLoader loader = new PlayerLoader();
                // Playerクラスの新たなオブジェクトを生成する
                Class<? extends Player> classOf;

                classOf = loader.loadClass(name).asSubclass(Player.class);
                Player player;

                player = classOf.newInstance();

                // ゲームを生成してプレーする
                Game game = new Game();
                player.play(game);
                
                // スコアを報告する
                game.reportScore(name);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void reportScore(String name) {
        System.out.printf(">> %s, your score is : %d %n" , name, score);
    }
    
    public void setScore(int score) {
        this.score = score;
    }
}
