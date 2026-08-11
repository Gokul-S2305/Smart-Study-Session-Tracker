import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static ArrayList<StudySession> sessions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        loadSessions();

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("      SMART STUDY SESSION TRACKER");
            System.out.println("========================================");

            System.out.println("1. Add Study Session");
            System.out.println("2. View All Sessions");
            System.out.println("3. Productivity Report");
            System.out.println("4. Subject Statistics");
            System.out.println("5. Save Sessions");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addSession();
                    break;

                case 2:
                    viewSessions();
                    break;

                case 3:
                    productivityReport();
                    break;

                case 4:
                    subjectStatistics();
                    break;

                case 5:
                    saveSessions();
                    break;                    

                case 6:
                    saveSessions();
                    System.out.println("\nThank you for using Smart Study Session Tracker!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    public static void addSession() {

        System.out.println("\n========== ADD STUDY SESSION ==========");

        String subject = getSafeText("Enter subject: ");

        int duration = getValidDuration();

        int focusLevel = getValidFocusLevel();

        String notes = getSafeText("Enter notes: ");

        StudySession session = new StudySession(
                subject,
                duration,
                focusLevel,
                notes
        );

        sessions.add(session);

        System.out.println("\nStudy session added successfully!");
    }

    public static void viewSessions() {

        System.out.println("\n========== ALL STUDY SESSIONS ==========");

        if (sessions.isEmpty()) {
            System.out.println("No study sessions recorded yet.");
            return;
        }

        int count = 1;

        for (StudySession s : sessions) {

            System.out.println("\nSession " + count);

            System.out.println("Subject  : " + s.getSubject());
            System.out.println("Duration : " + s.getDuration() + " minutes");
            System.out.println("Focus    : " + s.getFocusLevel() + "/10");
            System.out.println("Notes    : " + s.getNotes());

            count++;
        }
    }

    public static void productivityReport() {

        System.out.println("\n========== PRODUCTIVITY REPORT ==========");

        if (sessions.isEmpty()) {
            System.out.println("No study sessions available.");
            return;
        }

        int totalDuration = 0;
        int totalFocus = 0;

        for (StudySession s : sessions) {
            totalDuration += s.getDuration();
            totalFocus += s.getFocusLevel();
        }

        double averageFocus = (double) totalFocus / sessions.size();

        String productivity;

        if (averageFocus >= 9) {
            productivity = "EXCELLENT";
        } else if (averageFocus >= 7) {
            productivity = "HIGH";
        } else if (averageFocus >= 5) {
            productivity = "MODERATE";
        } else {
            productivity = "LOW";
        }

        System.out.println("Total Study Time : " + totalDuration + " minutes");
        System.out.println("Total Sessions   : " + sessions.size());
        System.out.printf("Average Focus    : %.1f / 10%n", averageFocus);
        System.out.println("Productivity     : " + productivity);

        System.out.println("\nRecommendation:");

        if (averageFocus >= 9) {
            System.out.println("Excellent focus! Keep maintaining this routine.");
        } else if (averageFocus >= 7) {
            System.out.println("Great work! Your focus level is strong.");
        } else if (averageFocus >= 5) {
            System.out.println("Good start! Try reducing distractions.");
        } else {
            System.out.println("Your focus is low. Try shorter study sessions with breaks.");
        }
    }

    public static void subjectStatistics() {

        System.out.println("\n========== SUBJECT STATISTICS ==========");

        if (sessions.isEmpty()) {
            System.out.println("No study sessions available.");
            return;
        }

        HashMap<String, Integer> subjectTime = new HashMap<>();
        HashMap<String, Integer> subjectSessions = new HashMap<>();
        HashMap<String, Integer> subjectFocus = new HashMap<>();

        for (StudySession s : sessions) {

            String subject = s.getSubject();

            subjectTime.put(
                    subject,
                    subjectTime.getOrDefault(subject, 0) + s.getDuration()
            );

            subjectSessions.put(
                    subject,
                    subjectSessions.getOrDefault(subject, 0) + 1
            );

            subjectFocus.put(
                    subject,
                    subjectFocus.getOrDefault(subject, 0) + s.getFocusLevel()
            );
        }

        String mostStudiedSubject = "";
        int highestTime = 0;

        for (String subject : subjectTime.keySet()) {

            int time = subjectTime.get(subject);
            int count = subjectSessions.get(subject);
            int focus = subjectFocus.get(subject);

            double averageFocus = (double) focus / count;

            System.out.println("\n" + subject);
            System.out.println("Sessions      : " + count);
            System.out.println("Total Time    : " + time + " minutes");
            System.out.printf("Average Focus : %.1f/10%n", averageFocus);

            if (time > highestTime) {
                highestTime = time;
                mostStudiedSubject = subject;
            }
        }

        System.out.println("\nMost Studied Subject : " + mostStudiedSubject);
        System.out.println("Total Study Time     : " + highestTime + " minutes");
    }
    
    public static void saveSessions() {

        try {
            FileWriter writer = new FileWriter("study_sessions.txt");

            for (StudySession s : sessions) {

                writer.write(
                        s.getSubject() + "|" +
                        s.getDuration() + "|" +
                        s.getFocusLevel() + "|" +
                        s.getNotes() + "\n"
                );
            }

            writer.close();

            System.out.println("\nStudy sessions saved successfully!");

        } catch (IOException e) {
            System.out.println("Error while saving sessions.");
        }
    }
    
    public static void loadSessions() {

        File file = new File("study_sessions.txt");

        if (!file.exists()) {
            return;
        }

        try {

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                String[] data = line.split("\\|", 4);

                String subject = data[0];
                int duration = Integer.parseInt(data[1]);
                int focusLevel = Integer.parseInt(data[2]);
                String notes = data[3];

                StudySession session = new StudySession(
                        subject,
                        duration,
                        focusLevel,
                        notes
                );

                sessions.add(session);
            }

            fileScanner.close();

            System.out.println("Previous study sessions loaded.");

        } catch (FileNotFoundException e) {

            System.out.println("No saved sessions found.");

        } catch (Exception e) {

            System.out.println("Error while loading sessions.");
        }
    }

    public static String getSafeText(String message) {

        while (true) {

            System.out.print(message);
            String input = sc.nextLine();

            if (input.contains("|")) {
                System.out.println("Invalid character '|' detected.");
                System.out.println("Please enter the text again.");
            } else if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else {
                return input;
            }
        }
    }
    
    public static int getValidDuration() {

        while (true) {

            System.out.print("Enter duration (minutes): ");

            if (sc.hasNextInt()) {

                int duration = sc.nextInt();
                sc.nextLine();

                if (duration > 0) {
                    return duration;
                }

                System.out.println("Duration must be greater than 0.");

            } else {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
    
    public static int getValidFocusLevel() {

        while (true) {

            System.out.print("Enter focus level (1-10): ");

            if (sc.hasNextInt()) {

                int focusLevel = sc.nextInt();
                sc.nextLine();

                if (focusLevel >= 1 && focusLevel <= 10) {
                    return focusLevel;
                }

                System.out.println("Focus level must be between 1 and 10.");

            } else {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
}