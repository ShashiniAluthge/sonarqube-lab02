package main.java.com.example;

public class App {

    public static void main(String[] args) throws Exception {

        // Calculator usage with enum (no magic strings)
        Calculator calculator = new Calculator();
        int result = calculator.calculate(10, 5, Calculator.Operation.ADD);
        System.out.println(result);

        // UserService with injected password (no hardcoding)
        UserService service = new UserService(
                System.getenv("DB_PASSWORD"));

        service.findUser("admin");
        service.deleteUser("admin");
    }
}
