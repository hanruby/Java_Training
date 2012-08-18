package ch16.ex16_11;

public class Game {
    public static void main(String[] args) {
        
        String name;    // class name
        
        while ((name = getNextPlayer()) != null) {
            try {
                PlayerLoader loader = new PlayerLoader();
                Class<? extends Player> classOf = loader.loadClass(name).asSubclass(Player.class);
                Player player = classOf.newInstance();
                Game game = new Game();

                player.play(game);
                game.reportScore(name);
                
            } catch (Exception e) {
                reportException(name, e);
            }
        }
    }

    private static void reportException(String name, Exception e) {
        // TODO Auto-generated method stub
        
    }

    private void reportScore(String name) {
        // TODO Auto-generated method stub
        
    }

    private static String getNextPlayer() {
        // TODO Auto-generated method stub
        return null;
    }
}
