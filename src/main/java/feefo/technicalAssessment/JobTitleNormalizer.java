package feefo.technicalAssessment;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JobTitleNormalizer {

    private List<String> idealTitles;

    private String ERROR_INPUT_EMPTY_OR_NULL = "job title input is empty or null!";

    private String ERROR_LIST_EMPTY_OR_NULL = "the list of ideal job titles is empty or null!";

    private String NO_MATCH_FOUND = "Unable to find a good match for the job title: '" +
            "%s' " +
            "in the list of ideal job titles.";

    private String HINT_MSG = "Possible solutions: " +
            "update the list of ideal titles or change the input for the job title";

    public JobTitleNormalizer(List<String> idealTitles) {
        if (idealTitles == null || idealTitles.isEmpty()) {
            throw new IllegalArgumentException(ERROR_LIST_EMPTY_OR_NULL);
        }
        this.idealTitles = idealTitles;
    }

    public String normalize(String inputTitle) {
        if (inputTitle == null || inputTitle.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_INPUT_EMPTY_OR_NULL);
        }

        double maxScore = 0.0;
        String bestMatch = null;

        for (String idealTitle : idealTitles) {
            double score = calculateScore(inputTitle, idealTitle);
            if (score > maxScore) {
                maxScore = score;
                bestMatch = idealTitle;
            }
        }

        if(bestMatch == null) {
            System.out.printf((NO_MATCH_FOUND) + "%n", inputTitle);
            System.out.println(HINT_MSG);
        }

        return bestMatch;
    }

    private double calculateScore(String s1, String s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split(" ")));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split(" ")));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }
}
