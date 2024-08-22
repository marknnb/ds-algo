
import java.util.*;
import java.util.stream.*;

public class TournamentWinner {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(
                new ArrayList<String>() {
            {
                add("HTML");
                add("C#");
            }
        }
        );
        competitions.add(
                new ArrayList<String>() {
            {
                add("C#");
                add("Python");
            }
        }
        );
        competitions.add(
                new ArrayList<String>() {
            {
                add("Python");
                add("HTML");
            }
        }
        );

        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);
        System.out.println(tournamentWinnerSolution2(competitions, results));
    }

    // time O(n2) | space O(n)
    public static String tournamentWinnerSolution1(ArrayList<ArrayList<String>> competitions,
            ArrayList<Integer> results) {
        // Write your code here.
        int i = 0;
        Map<String, Integer> matchResults = new HashMap<>();
        for (ArrayList<String> match : competitions) {
            int j = 0;
            for (String team : match) {
                int score = 0;
                if (!matchResults.containsKey(team)) {
                    matchResults.put(team, 0);
                }
                if (j == 0 && (results.get(i) == 1)) {
                    score = 3;
                }
                if (j == 1 && (results.get(i) == 0)) {
                    score = 3;
                }
                matchResults.put(team, (matchResults.get(team) + score));
                j++;
            }
            i++;
        }

        String name = "";
        int points = -1;
        for (var elem : matchResults.entrySet()) {
            String key = elem.getKey();
            int value = elem.getValue();
            if (points < value) {
                points = value;
                name = key;
            }
        }
        return name;
    }

    public static String tournamentWinnerSolution2(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        Map<String, Integer> matchResults = new HashMap<>();
        int i = 0;
        for (var matchScore : results) {
            var match = competitions.get(i);
            var winningTeam = match.get(Math.abs(matchScore - 1));
            if (!matchResults.containsKey(winningTeam)) {
                matchResults.put(winningTeam, 0);
            }
            matchResults.put(winningTeam, (matchResults.get(winningTeam) + 3));
            i++;
        }
        return Collections.max(matchResults.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String tournamentWinnerSolutionJava8(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        Map<String, Integer> matchResults = new HashMap<>();
        IntStream.range(0, results.size())
                .forEach(i -> {
                    var matchScore = results.get(i);
                    var match = competitions.get(i);
                    var winningTeam = match.get(Math.abs(matchScore - 1));
                    matchResults.merge(winningTeam, 3, Integer::sum);
                });
        return matchResults.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
}

// We can keep track of max while putting in map as well