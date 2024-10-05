import java.util.Scanner;

public class Main {
    public static BD bd=new BD();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean bool=true;
        while (bool) {
            System.out.println();
            System.out.println("""
                    1.Равномерное распределение вариантов среди студентов от 1 до 10
                    2.Вывод отсортированного списка студентов с вариантами
                    3.Вывод списка студентов сгруппированных по вариантам
                    4.Вывод варианта студента по фамилии
                    5.Вывод списка студентов с определенным вариантом
                    6.Вывод количества студентов с каждым вариантом
                    7.Вариант(на основе кода преподавателя)
                    8.Студент по варианту(на основе кода преподавателя)
                    9.Завершение работы программы
                    """);
            int swtch = scanner.nextInt();
            switch (swtch) {
                case 1: {//1.Равномерное распределение вариантов среди студентов от 1 до 10
                    bd.variantStudents();
                    System.out.println("Сделано");
                }
                break;
                case 2: {//2.Вывод отсортированного списка студентов с вариантами
                    bd.sortStudents();
                }
                break;
                case 3: {//3.Вывод списка студентов сгруппированных по вариантам
                    bd.studentsByVariants();
                }
                break;
                case 4: {//4.Вывод варианта студента по фамилии
                    System.out.println("Введите фамилию студента");
                    String fam = scanner.next();
                    bd.variantByStudent(fam);
                }
                break;
                case 5: {//5.Вывод списка студентов с определенным вариантом
                    System.out.println("Введите вариант");
                    int varik=scanner.nextInt();
                    bd.listOfStudentsByVariant(varik);
                }
                break;
                case 6: {//6.Вывод количества студентов с каждым вариантом
                    bd.numberOfStudentsByVariants();
                }
                break;
                case 7:{
                    bd.addVariant();
                }break;
                case 8:{
                    System.out.println("Введите фамилию студента");
                    String fam = scanner.next();
                    bd.variantOfStudent(fam);
                }break;
                case 9:{
                    bool=false;
                }break;
                case 10: {
                    boolean boolik = true;
                    while (boolik) {
                        System.out.println("1 или 2");
                        int boolswtch = scanner.nextInt();
                        switch (boolswtch) {
                            case 1: {
                                System.out.println("Фамилия");
                                String surname = scanner.next();
                                System.out.println("Имя");
                                String name = scanner.next();
                                System.out.println("Отчество");
                                String lastname = scanner.next();
                                System.out.println("Группа");
                                String group = scanner.next();
                                System.out.println("Вариант");
                                int var = scanner.nextInt();
                                bd.addStudent(surname, name, lastname, group, var);
                                System.out.println();
                            }
                            break;
                            case 2: {
                                bool = false;
                            }
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
}