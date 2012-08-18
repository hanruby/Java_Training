package ch16.ex16_11;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private static Queue<String> names = new LinkedList<String>();
    
    public Game() {
        // TODO Auto-generated constructor stub
        names.add("hoge");
    }
    
    public static void main(String[] args) {
        
        String name;    // class name
        
        while ((name = getNextPlayer()) != null) {
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
                reportException(name, e);
            } catch (InstantiationException e) {
                reportException(name, e);
            } catch (IllegalAccessException e) {
                reportException(name, e);
            }
        }
    }

    private static void reportException(String name, Exception e) {
        System.err.println(name + ":" + e.toString());
        e.printStackTrace();
    }

    private void reportScore(String name) {
        // TODO Auto-generated method stub
        
    }

    private static String getNextPlayer() {
        return names.poll();
    }
}
