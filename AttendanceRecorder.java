import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class AttendanceRecorder{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Boolean> attendance = new HashMap<>();

        // Add some example students (modify this section)
        attendance.put("Reginald Last", false);
        attendance.put("Royd Nyambe", false);
        attendance.put("Kausa Zimba", false);
        attendance.put("Patson Zyambo", false);
        attendance.put("Sydney", false);
        attendance.put("Chizo", false);
        attendance.put("Chilungu", false);

        // Take attendance
        System.out.println("Taking attendance:");
        for (String studentName : attendance.keySet()) {
            System.out.print("Is " + studentName + " present? (y/n): ");
            String response = scanner.nextLine().toLowerCase();
            attendance.put(studentName, response.equals("y"));
        }

        // Generate attendance list
        try {
            File attendanceFile = new File("attendance_list.txt");
            PrintWriter writer = new PrintWriter(attendanceFile);

            // Write header
            writer.println("Present Students:");

            // Write present students
            for (String studentName : attendance.keySet()) {
                if (attendance.get(studentName)) {
                    writer.println(studentName);
                }
            }

            writer.close();
            System.out.println("Attendance list saved to attendance_list.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Error creating attendance list file: " + e.getMessage());
        }
    }
}
