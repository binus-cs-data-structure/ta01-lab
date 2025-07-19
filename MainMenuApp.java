import java.util.Scanner;

public class MainMenuApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Customer Queue System");
            System.out.println("2. Text Editor (Undo/Redo)");
            System.out.println("3. Management Mahasiswa");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    runCustomerQueue(scanner);
                    break;
                case 2:
                    runTextEditor(scanner);
                    break;
                case 3:
                    runManagementMhs(scanner);
                    break;
                case 4:
                    System.out.println("Exiting main program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 3);

        scanner.close();
    }

    // Method to run Customer Queue System
    private static void runCustomerQueue(Scanner scanner) {
        CustomerQueueSystem.CustomerQueue queue = new CustomerQueueSystem.CustomerQueue();
        int choice;

        do {
            System.out.println("\n===== CUSTOMER SERVICE QUEUE =====");
            System.out.println("1. Add customer to the queue");
            System.out.println("2. Serve customer");
            System.out.println("3. Show all customers in queue");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    queue.enqueue(name);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    // Method to run Text Editor Stack System
    private static void runTextEditor(Scanner scanner) {
    TextEditorSystem editor = new TextEditorSystem();
    int choice;

    do {
        System.out.println("\n===== TEXT EDITOR =====");
        System.out.println("1. Add Text");
        System.out.println("2. Undo");
        System.out.println("3. Redo");
        System.out.println("4. Show Text");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose an option: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new text to add: ");
                String newText = scanner.nextLine();
                editor.addText(newText);
                break;
            case 2:
                editor.undo();
                break;
            case 3:
                editor.redo();
                break;
            case 4:
                editor.showText();
                break;
            case 5:
                System.out.println("Returning to Main Menu...");
                break; // keluar dari switch
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        } while (choice != 5); // kembali ke menu utama jika user memilih 5
    }

    private static void runManagementMhs(Scanner scanner) {
        MahasiswaLinkedList daftarMahasiswa = new MahasiswaLinkedList();
        int pilihan;

        do {
            System.out.println("Manajemen Data Mahasiswa:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Back to main menu");
            System.out.print("Pilihan: \n");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nilai: ");
                    int nilai = scanner.nextInt();
                    long startTime = System.nanoTime();
                    daftarMahasiswa.tambahMahasiswa(nim, nama, nilai);
                    long endTime = System.nanoTime();
                    System.out.println("Waktu eksekusi: " + (endTime - startTime) + " ns");
                    break;
                case 2:
                    System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    startTime = System.nanoTime();
                    daftarMahasiswa.hapusMahasiswa(nimHapus);
                    endTime = System.nanoTime();
                    System.out.println("Waktu eksekusi: " + (endTime - startTime) + " ns");
                    break;
                case 3:
                    System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
                    String nimUpdate = scanner.nextLine();
                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = scanner.nextInt();
                    startTime = System.nanoTime();
                    daftarMahasiswa.updateNilai(nimUpdate, nilaiBaru);
                    endTime = System.nanoTime();
                    System.out.println("Waktu eksekusi: " + (endTime - startTime) + " ns");
                    break;
                case 4:
                    startTime = System.nanoTime();
                    daftarMahasiswa.tampilkanDaftar();
                    endTime = System.nanoTime();
                    System.out.println("Waktu eksekusi: " + (endTime - startTime) + " ns");
                    break;
                case 5:
                    System.out.println("Return to main menu.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
