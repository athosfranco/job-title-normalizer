package feefo.technicalAssessment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> idealTitles = Arrays.asList(
                "Architect",
                "Software Engineer",
                "Quantity surveyor",
                "Accountant"
        );

        JobTitleNormalizer n = new JobTitleNormalizer(idealTitles);

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================[JOB TITLE NORMALIZER]======================");
        System.out.println("ABOUT: This system was developed by me, Athos Franco, as a solution to Feefo's Technical Assessment #1. ");
        System.out.println("HOW IT WORKS: the user should input a job title and the system will output a normalized job title, based on a list of ideal job titles. ");
        System.out.println("==================================================================");
        while (true) {
            System.out.print("Please, enter a job title to normalize (or type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.print("Bye! :)");
                break;
            }
            try {
                String normalizedTitle = n.normalize(input);
                if(normalizedTitle != null) {
                    System.out.println("✅ Normalized job title: " + normalizedTitle);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("❌ ERROR FOUND: " + e.getMessage());
            }
        }
        scanner.close();

    }
}
