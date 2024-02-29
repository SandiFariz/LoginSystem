import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password, nim;

        // Hardcoded admin credentials
        String adminUsername = "admin";
        String adminPassword = "password";

        // Hardcoded list of Mahasiswa NIMs
        String[] mahasiswaNIMs = {"123456789012345", "987654321098765"};



        // Loop for login attempts
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("\nSilakan login sebagai Admin atau Mahasiswa:");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM: ");
                    nim = scanner.nextLine();
                    if (isValidNIM(nim, 15) && isValidMahasiswa(nim, mahasiswaNIMs)) {
                        System.out.println("Successful Login as Student");
                        isLoggedIn = true;
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case 2:
                    System.out.print("Enter your Username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter your Password: ");
                    password = scanner.nextLine();
                    if (username.equals(adminUsername) && password.equals(adminPassword)) {
                        System.out.println("Succesful Login as Admin");
                        isLoggedIn = true;
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem login Library.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            scanner.close();
        }
    }

    // Function to check if NIM is valid
    public static boolean isValidNIM(String nim, int length) {
        return nim.length() == length;
    }

    // Function to check if Mahasiswa NIM is valid
    public static boolean isValidMahasiswa(String nim, String[] mahasiswaNIMs) {
        for (String validNIM : mahasiswaNIMs) {
            if (validNIM.equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
