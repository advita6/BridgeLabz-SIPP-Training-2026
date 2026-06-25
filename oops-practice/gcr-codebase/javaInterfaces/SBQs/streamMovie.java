interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming Service: Premium Plan Active (4K Streaming enabled).");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming Service: Cloud Gaming Pass Active (Unlimited access).");
    }
}

class SmartTV implements StreamingService, GamingService {
    private final String[] movies = {"Inception", "Interstellar", "The Matrix", "Avatar"};
    private final String[] games = {"Cyberpunk 2077", "Elden Ring", "FIFA 26", "Gran Turismo"};

    @Override
    public void streamMovie(String movieName) {
        System.out.println("Now Streaming movie: " + movieName);
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Launching game: " + gameName);
    }

    @Override
    public void showSubscriptionDetails() {
        System.out.println("=== Unified Smart TV Subscription Hub ===");
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayAllContent() {
        System.out.println("--- Available Movies ---");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }
        
        System.out.println("\n--- Available Games ---");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();
        
        System.out.println();
        tv.displayAllContent();
        
        System.out.println();
        tv.streamMovie("Interstellar");
        tv.playGame("Elden Ring");
    }
}