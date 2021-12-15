package test.autoRent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
@Data
@NoArgsConstructor
public class Driver {
    @Id
    @Column(name="driver_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Driver(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Column(name = "name")
    private String userName;
    @Column(name = "password")
    String password;
    @Column(name = "category")
    private String category;
    @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "driver_id")
    List<Order> orders;
}
