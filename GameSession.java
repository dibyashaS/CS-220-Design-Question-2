import java.util.*;
//Design problem 2B
//Record KDA values,number of times character is killed in a game, number of deaths, number of assists
//Update stats counter
//Log multiple game sessions
public class GameSession {
    private int kills;
    private int deaths;
    private int assists;
    private String dateTime;

    public GameSession(int kills, int deaths, int assists, String dateTime) {
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.dateTime = dateTime;
    }

    public int getKills() { 
        return kills; 
    }
    public int getDeaths() { 
        return deaths; 
    }
    public int getAssists() { 
        return assists; 
    }
    public String getDateTime() { 
        return dateTime; 
    }

    @Override
    public String toString() {
        return "Session date:"+dateTime+"-Kills:"+kills+"-Deaths:"+deaths+"-Assists:"+assists;
    }
}

class GameRecord {
    private String gameName;
    private List<GameSession> sessions;

    public GameRecord(String gameName) {
        this.gameName = gameName;
        this.sessions = new ArrayList<>();
    }

    public void addSession(GameSession session) {
        sessions.add(session);
    }

    public List<GameSession> getSessions() {
        return sessions;
    }

    public double[] getAverageKDA() {
        int totalKills = 0, totalDeaths = 0, totalAssists = 0;
        for (GameSession s : sessions) {
            totalKills += s.getKills();
            totalDeaths += s.getDeaths();
            totalAssists += s.getAssists();
        }
        int count = sessions.size();
        if (count == 0) return new double[] {0.0, 0.0, 0.0};//An array with 0.0 K,D and A
        return new double[] {
            (double) totalKills / count,
            (double) totalDeaths / count,
            (double) totalAssists / count
        };
    }

    public String getGameName() { return gameName; }
}

class KDATracker {
    private Map<String, GameRecord> gameRecords = new HashMap<>();

    public void addGameSession(String game, int kills, int deaths, int assists, String dateTime) {
        gameRecords.putIfAbsent(game, new GameRecord(game));
        gameRecords.get(game).addSession(new GameSession(kills, deaths, assists, dateTime));
    }

    public void printStats(String game) {
        GameRecord record = gameRecords.get(game);
        if (record == null) {
            System.out.println("No records found for"+game);
            return;
        }

        System.out.println("Sessions for"+game+":");
        for (GameSession session : record.getSessions()) {
            System.out.println(session);  
        }

        double[] avg = record.getAverageKDA();
        System.out.println("Average K/D/A:"+ avg[0] + "/" + avg[1] + "/" + avg[2]);
    }
}

