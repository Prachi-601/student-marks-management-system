import java.util.Scanner ;

public class Main{
    static void displayStudents(String[] studentNames , int[][] studentMarks,int studentCount){
        System.out.println("-------------------------");
        for(int i = 0 ; i < studentCount; i++){
                   System.out.println(i+1 +")Name: " + studentNames[i]);
                   System.out.println(" English Marks: " + studentMarks[i][0]);
                   System.out.println(" Maths Marks: " + studentMarks[i][1]);
                   System.out.println(" Physics Marks: " + studentMarks[i][2]);
                   System.out.println();
        }
        System.out.println("-------------------------");
    }

    static void calculateResults(String[] studentNames, int[][] studentMarks, int studentCounter){
        System.out.println("-------------------------");
        for (int i = 0 ; i < studentCounter ; i++){
            System.out.println(i+1 +")Name: " + studentNames[i]);
            int total = studentMarks[i][0] + studentMarks[i][1] + studentMarks[i][2];
            System.out.println("Total Marks: " + total+ "/300");
            double average = (double)total / 3 ;
            System.out.printf("Average: %.2f%n" , average);
            char grade ;
            if(average >= 90){
                grade = 'A';
            }
            else if (average >= 80) {
                grade = 'B';
            }
            else if (average >= 70) {
                grade = 'C';
            }
            else if (average >= 60) {
                grade = 'D';
            }
            else{
                grade = 'F';
            }
            System.out.println("Grade: " + grade);
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    static void searchStudent(String[] studentNames , int[][] studentMarks , String studentName , int studentCount){

        boolean found = false ;
        System.out.println("\n-------------------------");
        for(int i= 0 ; i < studentCount ; i++){
            if(studentNames[i].equalsIgnoreCase(studentName)){
                System.out.println("Name: " + studentNames[i]);
                System.out.println(" English Marks: " + studentMarks[i][0]);
                System.out.println(" Maths Marks: " + studentMarks[i][1]);
                System.out.println(" Physics Marks: " + studentMarks[i][2]);
                int total = studentMarks[i][0] + studentMarks[i][1] + studentMarks[i][2];
                System.out.println(" Total Marks: " + total+ "/300");
                double average = (double)total / 3 ;
                System.out.printf(" Average: %.2f%n" , average);
                char grade ;
                if(average >= 90){
                    grade = 'A';
                }
                else if (average >= 80) {
                    grade = 'B';
                }
                else if (average >= 70) {
                    grade = 'C';
                }
                else if (average >= 60) {
                    grade = 'D';
                }
                else{
                    grade = 'F';
                }
                System.out.println(" Grade: " + grade);
                System.out.println();
                found = true ;
            }
        }
        if (!found){
            System.out.println("Student Not Found!");
        }
        System.out.println("-------------------------");
    }

    static void displayRankings(String[] studentNames, int[][] studentMarks, int studentCount){
        int[] totals = new int[studentCount];
        String[] rankedNames = new String[studentCount];
        int[][] rankedMarks = new int[studentCount][3];

        for (int i = 0 ; i < studentCount ; i++){
            rankedNames[i] = studentNames[i];
            rankedMarks[i][0] = studentMarks[i][0];
            rankedMarks[i][1] = studentMarks[i][1];
            rankedMarks[i][2] = studentMarks[i][2];

        }
        for(int i = 0 ; i < studentCount ; i++){
            totals[i] = rankedMarks[i][0] + rankedMarks[i][1] + rankedMarks[i][2];
        }

        for (int i = 0 ; i < studentCount -1 ; i++){
            for (int j = 0 ; j < studentCount - i - 1 ; j++){
                if (totals[j] < totals[j + 1]){
                    int temp = totals[j];
                    totals[j] = totals[j+1];
                    totals[j+1] = temp ;

                    String tempName = rankedNames[j];
                    rankedNames[j] = rankedNames[j+1];
                    rankedNames[j+1] = tempName ;

                    for (int k = 0 ; k < 3 ; k++){
                            int tempMark = rankedMarks[j][k];
                            rankedMarks[j][k] = rankedMarks[j+1][k];
                            rankedMarks[j+1][k] = tempMark;
                    }
                }
            }
        }
        System.out.println("\n========== STUDENT RANKINGS ==========");
        for (int i = 0 ; i < studentCount ; i++){
            System.out.println("Rank: "+ (i+1));
            System.out.println("Name: " + rankedNames[i]);
            System.out.println("Total Marks: " + totals[i] +"/300");
            char grade ;
            double average = (double)totals[i]/3;
            System.out.printf("Average: %.2f%n" , average);
            if(average >= 90){
                grade = 'A';
            }
            else if (average >= 80) {
                grade = 'B';
            }
            else if (average >= 70) {
                grade = 'C';
            }
            else if (average >= 60) {
                grade = 'D';
            }
            else{
                grade = 'F';
            }
            System.out.println("Grade : " + grade);
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice ;
        System.out.println("===== Marks Management System =====\n");
        int totalStudents;
        do{
            System.out.print("Total Numbers of Students: ");
            totalStudents = sc.nextInt();

            if(totalStudents <= 0){
                System.out.println("Number of students must be greater than 0.");
            }
        }while(totalStudents <= 0);

        String [] studentNames = new String[totalStudents];
        int[][] studentMarks = new int[totalStudents][3];
        int studentCount = 0;
        do{
            System.out.println("\nMenu: ");
            System.out.println("1. Add Students");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Results");
            System.out.println("4. Search Student");
            System.out.println("5. Display Rankings");
            System.out.println("6. Exit\n");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    sc.nextLine();
                    String name ;
                    if(studentCount < totalStudents){
                        do{
                            System.out.print("Enter Student Name: ");
                            name = sc.nextLine().trim();

                            if(name.isEmpty()){
                                System.out.println("Name cannot be empty.\n");
                            }
                        }while(name.isEmpty());
                        studentNames[studentCount] = name ;

                        do{
                            System.out.print("English Marks: ");
                            studentMarks[studentCount][0] = sc.nextInt();

                            if (studentMarks[studentCount][0] < 0 || studentMarks[studentCount][0] > 100){
                                System.out.println("Marks must be between 0 and 100.\n");
                            }

                        }while(studentMarks[studentCount][0] < 0 || studentMarks[studentCount][0] > 100);

                        do{
                            System.out.print("Maths Marks: ");
                            studentMarks[studentCount][1] = sc.nextInt();

                            if (studentMarks[studentCount][1] < 0 || studentMarks[studentCount][1] > 100){
                                System.out.println("Marks must be between 0 and 100.\n");
                            }

                        }while(studentMarks[studentCount][1] < 0 || studentMarks[studentCount][1] > 100);

                        do{
                            System.out.print("Physics Marks: ");
                            studentMarks[studentCount][2] = sc.nextInt();

                            if (studentMarks[studentCount][2] < 0 || studentMarks[studentCount][2] > 100){
                                System.out.println("Marks must be between 0 and 100.\n");
                            }

                        }while(studentMarks[studentCount][2] < 0 || studentMarks[studentCount][2] > 100);

                        studentCount++;
                    }
                    else{
                        System.out.println("\nYou cannot add students more than " + totalStudents + ".");
                    }
                    break;
                case 2:
                    if(studentCount == 0){
                        System.out.println("No student have been added yet!\n");
                        break;
                    }
                    displayStudents(studentNames,studentMarks,studentCount);
                    break;
                case 3:
                    if(studentCount == 0){
                        System.out.println("No student have been added yet!\n");
                        break;
                    }
                    calculateResults(studentNames,studentMarks,studentCount);
                    break;
                case 4:
                    sc.nextLine();
                    if(studentCount == 0){
                        System.out.println("No students have been added yet.\n");
                        break;
                    }
                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();
                    searchStudent(studentNames,studentMarks,studentName,studentCount);
                    break;
                case 5:
                    if(studentCount == 0){
                        System.out.println("No students have been added yet.");
                        break;
                    }
                    displayRankings(studentNames,studentMarks,studentCount);
                    break;
                case 6:
                    System.out.println("===== Thank You =====");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter valid option number.");

            }


        }while(choice != 6);
    }
}