public class Main {
        public static void main(String[] args) {
            KDATracker tracker = new KDATracker();
    
            tracker.addGameSession("Call of Duty", 15, 5, 3, "2025-04-12 21:00");
            tracker.addGameSession("Call of Duty", 3, 10, 1, "2025-04-12 22:00");
            tracker.addGameSession("Valorant", 8, 6, 2, "2025-04-11 19:30");
    
            tracker.printStats("Call of Duty");
            System.out.println();
            tracker.printStats("Valorant");
            System.out.println();
            tracker.printStats("Overwatch"); 
        }
    }
