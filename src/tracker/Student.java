

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

class Student {

    public static final int TOTAL_JAVA_POINTS = 600;
    public static final int TOTAL_DSA_POINTS = 400;
    public static final int TOTAL_DB_POINTS = 480;
    public static final int TOTAL_SPRING_POINTS = 550;
    private final String firstName;
    private final String lastName;
    private final String email;
    private static Integer j_popularity = 0;
    private static Integer s_popularity = 0;
    private static Integer db_popularity = 0;
    private static Integer dsa_popularity = 0;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final HashMap<Integer, Student> studInfo = new HashMap<>();
    private static final HashMap<Integer, Subjects> Points = new HashMap<>();

    private static boolean checkName(String name) {
        String regex = "^[a-zA-Z](?!.*[-'][-'\"]).*[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static boolean checkMail(String mail) {
        String regex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    private static String MaxPopularity() {
        if (Points.isEmpty()) {
            return "n/a";
        }

        calculatePopularity();

        if (s_popularity == j_popularity && j_popularity == db_popularity && db_popularity == dsa_popularity) {
            return ("Java, Spring, Databases, DSA");
        }

        if (s_popularity == Math.max(Math.max(s_popularity, j_popularity), Math.max(db_popularity, dsa_popularity))) {
            return "Spring";
        } else if (j_popularity == Math.max(Math.max(s_popularity, j_popularity), Math.max(db_popularity, dsa_popularity))) {
            return "Java";
        } else if (db_popularity == Math.max(Math.max(s_popularity, j_popularity), Math.max(db_popularity, dsa_popularity))) {
            return "Databases";
        } else {
            return "DSA";
        }
    }

    private static String MinPopularity() {
        if (Points.isEmpty()) {
            return "n/a";
        }

        calculatePopularity();

        if (!MaxPopularity().equals("n/a")) {
            return "n/a";
        }

        if (s_popularity == j_popularity && j_popularity == db_popularity && db_popularity == dsa_popularity) {
            return ("Java, Spring, Databases, DSA");
        }

        if (s_popularity == Math.min(Math.min(s_popularity, j_popularity), Math.min(db_popularity, dsa_popularity))) {
            return "Spring";
        } else if (j_popularity == Math.min(Math.min(s_popularity, j_popularity), Math.min(db_popularity, dsa_popularity))) {
            return "Java";
        } else if (db_popularity == Math.min(Math.min(s_popularity, j_popularity), Math.min(db_popularity, dsa_popularity))) {
            return "Databases";
        } else {
            return "DSA";
        }
    }

    private static String MaxActivityCounter() {
        if (Points.isEmpty()) {
            return "n/a";
        }

        int j_activity = calculateActivity("Java");
        int s_activity = calculateActivity("Spring");
        int db_activity = calculateActivity("Databases");
        int dsa_activity = calculateActivity("DSA");

        if (s_activity == j_activity && j_activity == db_activity && db_activity == dsa_activity) {
            return ("Java, Spring, Databases, DSA");
        }

        if (s_activity == Math.max(Math.max(s_activity, j_activity), Math.max(db_activity, dsa_activity))) {
            return "Spring";
        } else if (j_activity == Math.max(Math.max(s_activity, j_activity), Math.max(db_activity, dsa_activity))) {
            return "Java";
        } else if (db_activity == Math.max(Math.max(s_activity, j_activity), Math.max(db_activity, dsa_activity))) {
            return "Databases";
        } else {
            return "DSA";
        }
    }

    private static String MinActivityCounter() {
        if (Points.isEmpty()) {
            return "n/a";
        }

        int j_activity = calculateActivity("Java");
        int s_activity = calculateActivity("Spring");
        int db_activity = calculateActivity("Databases");
        int dsa_activity = calculateActivity("DSA");

        if (!MaxActivityCounter().equals("n/a")) {
            return "n/a";
        }

        if (s_activity == j_activity && j_activity == db_activity && db_activity == dsa_activity) {
            return ("Java, Spring, Databases, DSA");
        }
        if (s_activity == Math.min(Math.min(s_activity, j_activity), Math.min(db_activity, dsa_activity))) {
            return "Spring";
        } else if (j_activity == Math.min(Math.min(s_activity, j_activity), Math.min(db_activity, dsa_activity))) {
            return "Java";
        } else if (db_activity == Math.min(Math.min(s_activity, j_activity), Math.min(db_activity, dsa_activity))) {
            return "Databases";
        } else {
            return "DSA";
        }
    }

    private static String Hardest() {
        if (Points.isEmpty()) {
            return "n/a";
        }

        int j_activity = calculateTotalActivity("Java");
        int s_activity = calculateTotalActivity("Spring");
        int db_activity = calculateTotalActivity("Databases");
        int dsa_activity = calculateTotalActivity("DSA");

        if (s_activity == j_activity && j_activity == db_activity && db_activity == dsa_activity) {
            return ("Java, Spring, Databases, DSA");
        }

        if (j_activity == Math.min(Math.min(j_activity, s_activity), Math.min(db_activity, dsa_activity))) {
            return "Java";
        } else if (s_activity == Math.min(Math.min(j_activity, s_activity), Math.min(db_activity, dsa_activity))) {
            return "Spring";
        } else if (db_activity == Math.min(Math.min(j_activity, s_activity), Math.min(db_activity, dsa_activity))) {
            return "Databases";
        } else {
            return "DSA";
        }
    }

    private static String Easiest() {
        if (Points.isEmpty()) {
            return "n/a";
        }

        int j_activity = calculateTotalActivity("Java");
        int s_activity = calculateTotalActivity("Spring");
        int db_activity = calculateTotalActivity("Databases");
        int dsa_activity = calculateTotalActivity("DSA");



        if (s_activity == j_activity && j_activity == db_activity && db_activity == dsa_activity) {
            return ("Java, Spring, Databases, DSA");
        }

        if (j_activity == Math.max(Math.max(j_activity, s_activity), Math.max(db_activity, dsa_activity))) {
            return "Java";
        } else if (s_activity == Math.max(Math.max(j_activity, s_activity), Math.max(db_activity, dsa_activity))) {
            return "Spring";
        } else if (db_activity == Math.max(Math.max(j_activity, s_activity), Math.max(db_activity, dsa_activity))) {
            return "Databases";
        } else {
            return "DSA";
        }
    }
    private static void displayCourseStatistics(String course, int totalPoints) {
        System.out.println(course);
        System.out.printf("%-5s %-5s %-8s%n", "id", "points", "completed");

        for (Integer studKey : Points.keySet()) {
            Student.Subjects subjects = Points.get(studKey);
            double percentage = (double) (getCoursePoints(course, subjects) * 100) / totalPoints;
            System.out.printf("%-5s %-5s %-8s%n", studKey, getCoursePoints(course, subjects), df.format(percentage) + "%");
        }
    }

    private static int getCoursePoints(String course, Student.Subjects subjects) {
        switch (course) {
            case "Java":
                return subjects.getJava();
            case "DSA":
                return subjects.getDsa();
            case "Databases":
                return subjects.getDb();
            case "Spring":
                return subjects.getSpring();
            default:
                return 0; // Or handle this case appropriately based on your application's logic
        }
    }

    static int count = 0;
    static int id = 10000;

    public static void main(String[] args) {
        System.out.println("Learning Progress Tracker");
        DecimalFormat df = new DecimalFormat("#.#");
        while (true) {
            String userInput = scanner.nextLine();
            String trimmedInput = userInput.trim();

            switch (trimmedInput) {
                case "":
                    System.out.println("No input");
                    break;

                case "list":
                    if (studInfo.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("Students:");
                        for (Integer studentId : studInfo.keySet()) {
                            System.out.println(studentId);
                        }
                    }
                    break;

                case "add points":
                    System.out.println("Enter ID and points (ID, Java, DSA, DB, Spring) or 'back' to return:");

                    while (true) {
                        String input = scanner.nextLine();

                        if (input.equalsIgnoreCase("back")) {
                            break;
                        }

                        String[] parts = input.split(" ");

                        if (parts.length != 5) {
                            System.out.println("Incorrect points format.");
                            continue;
                        }
                        String idStr = parts[0];

                        if (!idStr.matches("\\d+")) {
                            System.out.println("No student is found for id=" + idStr);
                            continue;
                        }

                        try {
                            int id = Integer.parseInt(parts[0]);
                            int java = Integer.parseInt(parts[1]);
                            int dsa = Integer.parseInt(parts[2]);
                            int db = Integer.parseInt(parts[3]);
                            int spring = Integer.parseInt(parts[4]);

                            if (!Points.containsKey(id)) {
                                System.out.println("No student is found for id=" + id);
                                continue;
                            }

                            if (java < 0 || java > 100 || dsa < 0 || dsa > 100 || db < 0 || db > 100 || spring < 0 || spring > 100) {
                                System.out.println("Incorrect points format.");
                                continue;
                            }

                            Student student = studInfo.get(id);
                            Student.Subjects existingSubjects = Points.get(id);

                            int updatedJava = existingSubjects.getJava() + java;
                            int updatedDsa = existingSubjects.getDsa() + dsa;
                            int updatedDb = existingSubjects.getDb() + db;
                            int updatedSpring = existingSubjects.getSpring() + spring;

                            Student.Subjects updatedSubjects = new Student.Subjects(updatedJava, updatedDsa, updatedDb, updatedSpring);

                            Points.put(id, updatedSubjects);
                            System.out.println("Points updated.");
                        } catch (NumberFormatException e) {
                            System.out.println("Incorrect points format.");
                        }
                    }
                    break;

                case "add students":
                    System.out.println("Enter student credentials or 'back' to return:");
                    while (true) {
                        String choice = scanner.nextLine();
                        boolean isValid = true;

                        if (choice.equals("back")) {
                            System.out.println("Total students added: " + count);
                            break;
                        }

                        String[] studentInfo = choice.split(" ");

                        if (studentInfo.length < 3) {
                            System.out.println("Incorrect credentials.");
                            isValid = false;
                        } else {
                            String studentEmail = studentInfo[studentInfo.length - 1];

                            if (!checkName(studentInfo[0])) {
                                System.out.println("Incorrect first name.");
                                isValid = false;
                            }

                            for (int i = 1; i < studentInfo.length - 1; i++) {
                                if (!checkName(studentInfo[i])) {
                                    System.out.println("Incorrect last name.");
                                    isValid = false;
                                    break;
                                }
                            }

                            if (!checkMail(studentEmail)) {
                                System.out.println("Incorrect email.");
                                isValid = false;
                            }

                            if (isValid) {
                                boolean emailTaken = false;
                                for (Student student : studInfo.values()) {
                                    if (student.getEmail().equals(studentEmail)) {
                                        emailTaken = true;
                                        break;
                                    }
                                }

                                if (emailTaken) {
                                    System.out.println("This email is already taken.");
                                } else {
                                    System.out.println("Student added.");
                                    Student newStudent = new Student(studentInfo[0], studentInfo[1], studentEmail);
                                    studInfo.put(id, newStudent);
                                    Student.Subjects subjects = new Student.Subjects(0, 0, 0, 0);
                                    Points.put(id, subjects);
                                    id++;
                                    count++;
                                }
                            }
                        }
                    }
                    break;

                case "find":
                    System.out.println("Enter ID or 'back' to return:");

                    while (true) {
                        String input = scanner.nextLine();

                        if (input.equalsIgnoreCase("back")) {
                            break;
                        }

                        try {
                            int studentId = Integer.parseInt(input);

                            if (Points.containsKey(studentId)) {
                                Student.Subjects subjects = Points.get(studentId);
                                System.out.printf("%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d%n", studentId, subjects.getJava(), subjects.getDsa(), subjects.getDb(), subjects.getSpring());
                            } else {
                                System.out.println("Student not found for ID " + studentId);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid student ID or 'back'.");
                        }
                    }
                    break;

                case "statistics":
                    System.out.println("Type the name of a course to see details or 'back' to quit:");
                    System.out.println("Most popular: " + MaxPopularity());
                    System.out.println("Least popular: " + MinPopularity());
                    System.out.println("Highest activity: " + MaxActivityCounter());
                    System.out.println("Lowest activity: " + MinActivityCounter());
                    System.out.println("Easiest course: " + Easiest());
                    System.out.println("Hardest course: " + Hardest());

                    while (true) {
                        String choice = scanner.next();
                        if (choice.equalsIgnoreCase("back")) {
                            break;
                        }
                        switch (choice) {
                            case "Java":
                            case "DSA":
                            case "Databases":
                            case "Spring":
                                displayCourseStatistics(choice, getCoursePoints(choice));
                                break;
                            default:
                                System.out.println("Unknown course.");
                                break;
                        }
                    }
                    break;

                case "exit":
                    System.out.println("Bye.");
                    scanner.close();
                    System.exit(0);
                    break;


                case "back" :
                    System.out.println("Enter 'exit' to exit the program.");
                    break;

                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }

    private static void calculatePopularity() {
        j_popularity = 0;
        s_popularity = 0;
        db_popularity = 0;
        dsa_popularity = 0;

        for (Student.Subjects subjects : Points.values()) {
            j_popularity += subjects.getJava() > 0 ? 1 : 0;
            s_popularity += subjects.getSpring() > 0 ? 1 : 0;
            db_popularity += subjects.getDb() > 0 ? 1 : 0;
            dsa_popularity += subjects.getDsa() > 0 ? 1 : 0;
        }
    }


    private static int calculateActivity(String courseName) {
        int activityCount = 0;

        for (Student.Subjects subjects : Points.values()) {
            switch (courseName) {
                case "Java":
                    activityCount += subjects.getJava() > 0 ? 1 : 0;
                    break;
                case "DSA":
                    activityCount += subjects.getDsa() > 0 ? 1 : 0;
                    break;
                case "Databases":
                    activityCount += subjects.getDb() > 0 ? 1 : 0;
                    break;
                case "Spring":
                    activityCount += subjects.getSpring() > 0 ? 1 : 0;
                    break;
            }
        }

        return activityCount;
    }



    private static int calculateTotalActivity(String courseName) {
        int totalActivity = 0;

        for (Student.Subjects subjects : Points.values()) {
            switch (courseName) {
                case "Java":
                    totalActivity += subjects.getJava();
                    break;
                case "DSA":
                    totalActivity += subjects.getDsa();
                    break;
                case "Databases":
                    totalActivity += subjects.getDb();
                    break;
                case "Spring":
                    totalActivity += subjects.getSpring();
                    break;
            }
        }

        return totalActivity;
    }





    private static int getFieldPoints(String fieldName, Student.Subjects subjects) {
        switch (fieldName) {
            case "Java":
                return subjects.getJava();
            case "Dsa":
                return subjects.getDsa();
            case "Db":
                return subjects.getDb();
            case "Spring":
                return subjects.getSpring();
            default:
                return 0;
        }
    }



    static class Subjects {
        private final int java;
        private final int dsa;
        private final int db;
        private final int spring;

        public Subjects(int java, int dsa, int db, int spring) {
            this.java = java;
            this.dsa = dsa;
            this.db = db;
            this.spring = spring;
        }

        public int getJava() {
            return java;
        }

        public int getDsa() {
            return dsa;
        }

        public int getDb() {
            return db;
        }

        public int getSpring() {
            return spring;
        }
    }
}
