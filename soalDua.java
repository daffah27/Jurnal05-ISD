import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class soalDua {

    public static void main(String[] args) {
        Queue<String> toDoList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("==========Menu==========");
            System.out.println("1. Tambah pekerjaan");
            System.out.println("2. Tampilkan pekerjaan yang harus diselesaikan");
            System.out.println("3. Hapus pekerjaan yang sudah diselesaikan");
            System.out.println("4. Tampilkan seluruh isi to-do list");
            System.out.println("5. Keluar");

            System.out.print("Pilihan menu : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pekerjaan yang harus dilakukan: ");
                    String task = scanner.nextLine();
                    toDoList.add(task);
                    System.out.println("Pekerjaan \"" + task + "\" telah ditambahkan ke to-do list.");
                    break;
                case 2:
                    if (toDoList.isEmpty()) {
                        System.out.println("To-do list kosong.");
                    } else {
                        System.out.println("Pekerjaan yang harus diselesaikan terlebih dahulu: " + toDoList.peek());
                    }
                    break;
                case 3:
                    if (toDoList.isEmpty()) {
                        System.out.println("To-do list kosong.");
                    } else {
                        String completedTask = toDoList.remove();
                        System.out.println("Pekerjaan \"" + completedTask + "\" telah selesai dan dihapus dari to-do list.");
                    }
                    break;
                case 4:
                    if (toDoList.isEmpty()) {
                        System.out.println("To-do list kosong.");
                    } else {
                        System.out.println("Isi to-do list:");
                        for (String item : toDoList) {
                            System.out.println("- " + item);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih! Program ditutup.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan pilihan yang benar.");
            }
            
        } while (choice != 5);
    }
}
