package org.example;
import java.util.Scanner;
import java.util.Random;

public class Turma {
    static Scanner scanner = new Scanner(System.in);
    static String[] prisonersFirstNames = new String[100];
    static String[] prisonersLastNames = new String[100];
    static int[] daysUntilRelease = new int[100];
    static int prisonersCount = 0;
    static int beliversCount = 0;
    static  String reasonOrestes = "";
    String firstName; //имя
    String lastName; //фамилия
    int reputation;

    // Статический метод
    public static void main(String[] args) {
        Turma turma = new Turma(); // Создание объекта класса для вызова нестатических методов
        turma.printWelcomeMessage(); // Вызов нестатического метода

    }

    // Нестатический метод
    public void printWelcomeMessage() {
        System.out.println("Добро пожаловать в тюрьму The END!");
        System.out.println("Хотите просмотреть описание тюрьмы? (да/нет)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("да")) {
            printPrisonDescription();
        } else if (choice.equals("нет")) {
            askMainMenuOrExit();
        } else {
            System.out.println("Неверный ввод. Попробуйте еще раз.");
            printWelcomeMessage();
        }
    }

    // Нестатический метод
    public void askMainMenuOrExit() {
        System.out.println("Хотите вернуться в главное меню или посмотреть информацио об система репутаций или выйти из программы? \n" +
                "(главное/система репутаций/выход)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("главное")) {
            mainMenu();
        }
        else if (choice.equals("выход")) {
            printGoodbyeMessage(); // Вызов статического метода
        }
        else if (choice.equals("система репутаций")) {
            reputationsystem();
        }
        else {
            System.out.println("Не правильный ввод попробуй ещё раз");
            askMainMenuOrExit();
        }
    }

    // Нестатический метод
    public void mainMenu() {
        System.out.println("Выберите за кого будет совершен вход:");
        System.out.println("1. Надзиратель");
        System.out.println("2. Заключенный");
        System.out.println("3. Выход из программы");
        System.out.println("4. зайти как хакер и изменить некоторые данные");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                managePrisoners();
                break;
            case 2:
                viewDaysUntilRelease();
                break;
            case 3:
                printGoodbyeMessage(); // Вызов статического метода
                break;
            case 4:
                hackers();
                break;
            default:
                printInvalidInputMessage();
                mainMenu();
        }
    }

    // Нестатический метод
    public void managePrisoners() {
        System.out.println("Количество заключённых " + prisonersCount);
        System.out.println("Введите фамилию заключенного:");
        lastName = scanner.next();
        System.out.println("Введите имя заключенного:");
        firstName = scanner.next();
        System.out.println("Введите количество дней до выхода заключенного:");
        int days = scanner.nextInt();
        prisonersFirstNames[prisonersCount] = firstName;
        prisonersLastNames[prisonersCount] = lastName;
        daysUntilRelease[prisonersCount] = days;
        reasonOrestes();
        prisonersCount++;
        System.out.println("Информация о заключенном успешно добавлена.");
        System.out.println("Количество заключённых " + prisonersCount);
        mainMenu();
    }

    // Нестатический метод
    public void viewDaysUntilRelease() {
        System.out.println("Введите вашу фамилию:");
        lastName = scanner.next();
        System.out.println("Введите ваше имя:");
        firstName = scanner.next();
        boolean found = findPrisoner(firstName, lastName);
        if (!found) {
            System.out.println("Заключенный не найден. Попробуйте еще раз.");
            viewDaysUntilRelease();
        }
        else {
            beliverss(firstName, lastName);
        }
    }

    // Нестатический метод
    public boolean findPrisoner(String firstName, String lastName) {
        boolean found = false;
        for (int i = 0; i < prisonersCount; i++) {
            if (prisonersFirstNames[i].equalsIgnoreCase(this.firstName)) {
                if (prisonersLastNames[i].equalsIgnoreCase(this.lastName)) {
                    found = true;
                    System.out.println("репутация" + reputation);
                    System.out.println("До выхода заключенного " + this.firstName + " " + this.lastName + " осталось " + daysUntilRelease[i] + " дней.");
                    System.out.println("причина заключения " + reasonOrestes);
                    break;
                }
            }
        }
        return found;
    }

    // Нестатический метод
    public void printPrisonDescription() {
        System.out.println("Описание тюрьмы:");
        System.out.println("Тюрьма \"The END\" — современное учреждение с высокими стенами и охраной, где каждый заключенный имеет свою индивидуальную камеру. \n " +
                "Внутри тюрьмы есть офисы для надзирателей и комнаты для совещаний.  \n " +
                "Системы безопасности включают видеонаблюдение и биометрическую идентификацию. \n " +
                "Администрация учреждения стремится к безопасной среде как для заключенных, так и для сотрудников.");
        askMainMenuOrExit();
    }

    // Статический метод
    public static void printGoodbyeMessage() {
        System.out.println("До свидания!");
        System.exit(0);
    }

    // Статический метод
    public void printInvalidInputMessage() {
        System.out.println("Неверный ввод. Попробуйте еще раз.");
        mainMenu();
    }

    public void beliverss(String firstName, String lastName){
        System.out.println("Хотите выступить в религию? (да/нет)");
        String beliver = scanner.next();
        switch (beliver) {
            case "да":
                beliversCount++;
                for(int y = 0; y < beliversCount; y++) {
                    if (prisonersFirstNames[y].equalsIgnoreCase(this.firstName)) {
                        if (prisonersLastNames[y].equalsIgnoreCase(this.lastName)) {
                            System.out.println("Теперь заключенный " + this.firstName + " " + this.lastName + " является веруюшим");
                            break;
                        }
                    }
                }
                bv();
                break;
            case "нет":
                levelup();
        }
    }
    public void bv() {
        System.out.println("Из-за того что вы веруюший ваша репутация в турьме у охраников поднялась  \n " +
                "и охрана начала относится к вас с доверием  \n " +
                "Теперь вы можете дольше находится на улице и за вами будет меньше следить");
        System.out.println("Количестов веруюших: "+ beliversCount);
    }

    public static void reasonOrestes(){
        System.out.println("Введити причину ореста преступника");
        String cause = scanner.next();
        reasonOrestes = cause;
    }

    public void reputationsystem(){
        System.out.println("Система репутаций в тюрьме\n" +
                "\n" +
                "Система репутаций в тюрьме - это неофициальный набор правил, который определяет поведение заключенных и их статус внутри тюремной иерархии. \n" +
                "Она основана на уважении, лояльности и соблюдении правил.\n" +
                "\n" +
                "Нарушение правил системы репутаций может привести к избиениям, потере статуса или даже смерти.\n" +
                "\n" +
                "Система репутаций поддерживает порядок в тюрьмах, но также может быть жестокой и несправедливой.");
        System.out.println("Максимальное количесто репутаций это 100 едениц. \n" +
                "1.100 репутация озночает, что вы босс у заключерных. \n" +
                "2.80-90 репутация озночает, что вы в очень хороших отношения с боссом(можно сказать что вы зам главы) и у вас незначительно меньше власти чем у него. \n" +
                "3.60-70 репутация озночает, что вы  один из дучших людей босса. \n" +
                "4.40-60 репутация озночает, что вы обычная шестерка. \n" +
                "5.20-40 репутация озночает, что вы чем-то заинтересовали зам главу или босса. \n" +
                "6.10-20 репутация озночает, что вы никого не заинтересовали. \n" +
                "7.0-10 репутация озночает, что вас даже не замечают и этим можно воспользоватся)."
        );
        askMainMenuOrExit();
    }
    public void hackers(){
        if(prisonersCount == 0){
            System.out.println("Увы пока что в турьме никого нет, изменять нечего");
            mainMenu();
        }
        else {
            System.out.println("Теперь вы являетесь хакером \n " +
                    "вы сможете выстовлять количесто единиц репутаций для каждого заключеного \n " +
                    "для этого вам нужно ввести данные каждого заключеного");
        }
        System.out.println("Количество заключённых " + prisonersCount);
        System.out.println(firstName + " " + lastName);
        System.out.println("Введите фамилию заключенного:");
        String oneName = scanner.next();
        System.out.println("Введите имя заключенного:");
        String twoName = scanner.next();
        if (firstName.equals(twoName) || lastName.equals(oneName)){
            System.out.println(reasonOrestes);
            System.out.println("Введите изночальное количество репутаций из полученых данных");
            reputation = scanner.nextInt();
            if (reputation > 100){
                System.out.println("Error try agean");
                hackers();
            }
            mainMenu();
        }
        else {
            System.out.println("Имя или фамиялия не соответствуют. Попрубуйте еще раз");
            hackers();
        }
    }

    public void levelup(){
        System.out.println("Хотите пывить уровень репутаций? (да/нет)");
        String lvl = scanner.next();
        switch (lvl){
            case "да":
                leveluprep();
            case "нет":
                break;
        }
    }

    public  void leveluprep(){
        System.out.println("Для повышения репутаций вам нужно будет закруит колесо удачи(рандомайзер) \n" +
                "если выпашее число будет больше вашей репутации то она подниматся настолько насколько выпало число");
        int randomNumber = (int) (Math.random() * 100) + 1;
        System.out.println(randomNumber);
        if(randomNumber <= reputation) {
            reputation = randomNumber;
            System.out.println(reputation);
        }
        else {
            System.out.println("У вас репутация больше выпавшего его нельзя изменить");
            System.out.println("Хотите попробывать снова? (да/нет)");
            String repyte = scanner.next();
            switch (repyte){
                case ("да"):
                    leveluprep();
                case ("нет"):
                    mainMenu();
            }
        }
    }
}