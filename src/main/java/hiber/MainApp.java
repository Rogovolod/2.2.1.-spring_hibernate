package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car("Тойота",5456);
      Car car2 = new Car("Ферари",777);
      Car car3 = new Car("Тесла",2101);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));

      User userHavingCar = userService.getUserCar("Тесла",2101);
      System.out.println(userHavingCar);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      context.close();
   }
}
