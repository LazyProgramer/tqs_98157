package lab3_2.CarService.lab3_2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carID;

    private String maker;

    private String model;

    public Car(){}

    public Car(String maker, String model){
        this.maker = maker;
        this.model = model;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    public long getCarID() {
        return carID;
    }
    public String getMaker() {
        return maker;
    }
    public String getModel() {
        return model;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car [Id: " + this.carID + " |Maker: " + this.maker + " |Model: " + this.model + "]";
    }
}
