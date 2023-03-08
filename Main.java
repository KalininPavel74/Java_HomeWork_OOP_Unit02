package unit2;

import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Инициализация логера
        MyLog.loggerInit(MyLog.LOG_FILE);
        // Запуск соревнования
        new Competition();
    }
}
