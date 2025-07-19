import java.util.Scanner;

class Node {
    private String nim;
    private String nama;
    private int nilai;
    private Node next;
    private Node prev;

    public Node(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.next = null;
        this.prev = null;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

class MahasiswaLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MahasiswaLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Menambahkan mahasiswa 
    public void tambahMahasiswa(String nim, String nama, int nilai) {
        Node newNode = new Node(nim, nama, nilai);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
        System.out.println("Mahasiswa " + nama + " berhasil ditambahkan.");
    }

    // Menghapus mahasiswa berdasarkan NIM
    public void hapusMahasiswa(String nim) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.getNim().equals(nim)) {
                found = true;
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.getNext();
                    head.setPrev(null);
                } else if (current == tail) {
                    tail = tail.getPrev();
                    tail.setNext(null);
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                size--;
                System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
                break;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    // Mengupdate nilai mahasiswa berdasarkan NIM
    public void updateNilai(String nim, int nilaiBaru) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.getNim().equals(nim)) {
                current.setNilai(nilaiBaru);
                found = true;
                System.out.println("Nilai mahasiswa " + current.getNama() + " berhasil diupdate menjadi " + nilaiBaru);
                break;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    // Menampilkan daftar mahasiswa
    public void tampilkanDaftar() {
        if (size == 0) {
            System.out.println("Daftar mahasiswa kosong.");
            return;
        }

        System.out.println("Daftar Mahasiswa:");
        Node current = head;
        int counter = 1;
        while (current != null) {
            System.out.println(counter + ". NIM: " + current.getNim() + 
                               ", Nama: " + current.getNama() + 
                               ", Nilai: " + current.getNilai());
            current = current.getNext();
            counter++;
        }
    }

    public int getSize() {
        return size;
    }
}

public class ManagementMahasiswa {
    public static void main(String[] args) {
        MahasiswaLinkedList daftarMahasiswa = new MahasiswaLinkedList();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Manajemen Data Mahasiswa:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
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
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}