import java.util.Scanner;
import java.util.Stack;

public class TextEditorSystem {
    
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private String currentText = "";

    public void addText(String newText) {
        undoStack.push(currentText); // simpan keadaan sebelumnya
        currentText += newText;
        redoStack.clear(); // redo tidak valid setelah penambahan teks baru
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);
            currentText = undoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);
            currentText = redoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-redo.");
        }
    }

    public void showText() {
        System.out.println("Teks saat ini: \"" + currentText + "\"");
    }

    public static void main(String[] args) {
        TextEditorSystem editor = new TextEditorSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tampilkan Teks");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan teks: ");
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
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
