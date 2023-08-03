import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isExit = false;

        while (!isExit) {
            Scanner i = new Scanner(System.in);
            System.out.print("Введите 1 чтобы Добавить человека или 2 чтобы закрыть программу: ");
            try {
                int num = i.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Добавить человека");
                        writeHumanInFile();
                        break;

                    case 2:
                        System.out.println("Выход");
                        isExit = true;
                        break;

                    default:
                        System.out.println("Введено неверное значение, повторите");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Введено неверное значение, повторите");
            }
        }
    }

    public static void writeHumanInFile() {
        String[] humanInfo = getValidInfo();
        Human h = null;
        try {
            h = getHuman(humanInfo);
            File file = new File(h.getFamilyName() + ".txt");

            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                String text = "";

                while (scanner.hasNext()) {
                    String temp = scanner.nextLine();
                    if (!temp.equals(h.toString())) {
                        text += temp + "\n";
                    }
                }

                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(text);
                    fw.write(h.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(h.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неверный формат даты рождения");
        } catch (NumberFormatException e) {
            System.out.println("Дата должна состоять из чисел");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Human getHuman(String[] humanInfo) throws Exception {
        String[] date = humanInfo[3].split("\\.");

        Human human = new Human(
                humanInfo[0],
                humanInfo[1],
                humanInfo[2],
                new Date(
                        Integer.parseInt(date[2]) - 1900,
                        Integer.parseInt(date[1]) - 1,
                        Integer.parseInt(date[0])
                ),
                Long.valueOf(humanInfo[4]),
                humanInfo[5].equals((String) "m") ? Sex.Male : Sex.Female);

        return human;
    }

    public static String[] getValidInfo() {
        boolean isValidInfo = false;
        String[] human;

        while (!isValidInfo) {
            human = getHumanInfo(getString());

            int length = getInfoCount(human);
            if (length != 6) {
                System.out.println(checkError(length));
                System.out.println("Повторите ввод данных...");
            } else {
                System.out.println("Данные успешно приняты!");
                return human;
            }
        }
        return new String[0];
    }


    public static String getString() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите информацию в формате - Фамилия Имя Отчество Дата рождения(dd.mm.yyyy) Номер телефона(79876543210) Пол(f/m): ");
        while (true) {
            String temp = sc.nextLine();
            if (!temp.equals("")) {
                return temp;
            }
        }
    }

    public static String[] getHumanInfo(String text) {
        return text.split(" ");
    }

    public static int getInfoCount(String[] text) {
        if (text.length > 6) {
            return 1100;
        } else if (text.length < 6) {
            return 900;
        } else {
            return text.length;
        }
    }

    public static String checkError(int error) {
        if (error == 1100) return String.format("Код ошибки - %d: Указано больше элементов информации", error);
        else if (error == 900) return String.format("Код ошибки - %d: Указано меньше элементов информации", error);
        return String.format("Код ошибки - %d", error);
    }
}