package main.java.com.example;

import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {

        // Calculator usage with enum (no magic strings)
        Calculator calculator = new Calculator();
        int result = calculator.calculate(10, 5, Calculator.Operation.ADD);

        LOGGER.info("Calculation result: " + result);

        // UserService with injected password (no hardcoding)
        UserService service = new UserService(
                System.getenv("DB_PASSWORD"));

        service.findUser("admin");
        service.deleteUser("admin");
    }
}
