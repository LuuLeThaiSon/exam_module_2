import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManager implements CRUD, Serializable {
    private ArrayList<Student> students;

    IOFile<ArrayList<Student>> ioFile = new IOFile<>();

    public StudentManager() {
        if (readFile() == null) {
            students = new ArrayList<>();
        } else {
            students = readFile();
        }
    }

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> readFile() {
        return ioFile.readFile("src/data/student.csv");
    }

    public void writeFile() {
        ioFile.writeFile(students, "src/data/student.csv");
    }

    @Override
    public void add(Scanner scanner) {
        System.out.println("Thêm mới sinh viên");
        System.out.print("Nhập mã sinh viên: ");
        String code = scanner.nextLine();
        if (code.equals("")) {
            System.out.println("Không được để trống thông tin");
            return;
        }
        System.out.print("Nhập họ tên sinh viên: ");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("Không được để trống thông tin");
            return;
        }
        System.out.print("Nhập tuổi: ");
        String age = scanner.nextLine();
        if (age.equals("")) {
            System.out.println("Không được để trống thông tin");
            return;
        }
        System.out.print("Giới tính (1: Nam, 2: Nữ): ");
        String gender = scanner.nextLine();
        if (gender.equals("")) {
            System.out.println("Không được để trống thông tin");
            return;
        }
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        if (address.equals("")) {
            System.out.println("Không được để trống thông tin");
            return;
        }
        System.out.print("Nhâp điểm trung bình: ");
        String avg = scanner.nextLine();
        if (avg.equals("")) {
            System.out.println("Không được để trống thông tin");
            return;
        }
        if (checkGender(gender) == 1) {
            students.add(new Student(code, name, Integer.parseInt(age), "Nam", address, Float.parseFloat(avg)));
        } else if (checkGender(gender) == 2) {
            students.add(new Student(code, name, Integer.parseInt(age), "Nữ", address, Float.parseFloat(avg)));
        } else {
            System.out.println("Nhập sai định dạng giới tính");
            return;
        }
        System.out.println("Thêm sinh viên thành công");
        writeFile();
    }


    @Override
    public void update(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        String code = scanner.nextLine();
        if (checkCodeStudent(code) == -1) {
            System.out.println("Không có sinh viên mã " + code);
        } else {
            int index = checkCodeStudent(code);
            System.out.print("Nhập mã mới: ");
            String newCode = scanner.nextLine();
            if (!newCode.equals("")) {
                students.get(index).setCode(newCode);
            }
            System.out.print("Nhập tên mới: ");
            String name = scanner.nextLine();
            if (!name.equals("")) {
                students.get(index).setName(name);
            }
            System.out.print("Nhập tuổi mới: ");
            String age = scanner.nextLine();
            if (!age.equals("")) {
                students.get(index).setAge(Integer.parseInt(age));
            }
            System.out.print("Nhập giới tính mới (1: Nam, 2: Nữ): ");
            String gender = scanner.nextLine();
            if (!gender.equals("")) {
                if (checkGender(gender) == 1) {
                    students.get(index).setGender("Nam");
                } else if (checkGender(gender) == 2) {
                    students.get(index).setGender("Nữ");
                } else {
                    System.out.println("Nhập sai định dạng giới tính");
                    return;
                }
            }
            System.out.print("Nhập địa chỉ mới: ");
            String address = scanner.nextLine();
            if (!address.equals("")) {
                students.get(index).setAddress(address);
            }

            System.out.print("Nhập điểm trung bình mới: ");
            String avg = scanner.nextLine();
            if (!avg.equals("")) {
                students.get(index).setAvg(Float.parseFloat(avg));
            }
            System.out.println("Sửa thông tin sinh viên thành công");
        }
        writeFile();
    }

    @Override
    public void delete(Scanner scanner) {
        System.out.print("Nhập mã sinh viên muốn xóa: ");
        String code = scanner.nextLine();
        int index = checkCodeStudent(code);
        if (index == -1) {
            System.out.println("Không có sinh viên mã " + code);
        } else {
            students.remove(index);
            System.out.println("Xóa thành công sinh viên mã " + code);
        }
        writeFile();
    }

    public void sortAscending() {
        ArrayList<Student> student = (ArrayList<Student>) students.clone();
        student.sort(Comparator.comparing(Student::getAvg));
        for (Student std : student) {
            System.out.println(std);
        }
    }


    public void sortDescending() {
        ArrayList<Student> student = (ArrayList<Student>) students.clone();
        student.sort(Comparator.comparing(Student::getAvg));
        for (int i = student.size() - 1; i >= 0; i--) {
            System.out.println(student.get(i));
        }
    }

    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public int checkGender(String str) {
        if (str.equals("1")) {
            return 1;
        } else if (str.equals("2")) {
            return 2;
        }
        return 0;
    }

    public int checkCodeStudent(String str) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCode().equals(str)) {
                return i;
            }
        }
        return -1;
    }

}
