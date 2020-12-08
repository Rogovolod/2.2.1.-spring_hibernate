package hiber.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
   @Id
   @Column(name = "series")
   private int series;
   @Column(name = "model")
   private String model;

   public Car() {
   }

   public Car(String model, int series) {
      this.model = model;
      this.series = series;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public int getSeries() {
      return series;
   }

   public void setSeries(int series) {
      this.series = series;
   }

   @Override
   public String toString() {
      return "Car{" +
              "series=" + series +
              ", model='" + model + '\'' +
              '}';
   }
}