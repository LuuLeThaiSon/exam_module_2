import java.util.Scanner;

public class StudentSystem {
    StudentManager studentManager;
    Scanner scanner;

    public StudentSystem() {
        this.studentManager = new StudentManager();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        do {
            try {
                System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN----");
                System.out.println("Chọn chức năng theo số (để tiếp tục)");
                System.out.println("1. Xem danh sách sinh viên");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp");
                System.out.println("6. Đọc từ file");
                System.out.println("7. Ghi vào file");
                System.out.println("8. Thoát");

                System.out.print("Chọn chức năng: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        studentManager.readFile();
                        studentManager.display();
                        break;
                    case 2:
                        studentManager.readFile();
                        studentManager.add(scanner);
                        break;
                    case 3:
                        studentManager.readFile();
                        studentManager.update(scanner);
                        break;
                    case 4:
                        studentManager.readFile();
                        studentManager.delete(scanner);
                        break;
                    case 5:
                        avgSubMenu();
                        break;
                    case 8:
                        System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("Nhập sai định dạng. Nhập lại");
            }
        } while (true);
    }

    public void avgSubMenu() {
        do {

            System.out.println("----Sắp xếp sinh viên theo điểm trung bình----");
            System.out.println("1. Sắp xêm điểm trung bình tăng dần");
            System.out.println("2. Sắp xêm điểm trung bình giảm dần");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice > 3 || choice < 0) {
                System.out.println("Nhập sai lựa chọn");
            } else if (choice == 3) {
                break;
            } else if (choice == 1){
                studentManager.sortAscending();
            } else if (choice == 2){
                studentManager.sortDescending();
            }
        } while (true);
    }
}
