package test.autoRent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "landlord")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Landlord{
    @Id
    @Column(name="landlord_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany(mappedBy="landlord",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    List<Car> cars;
}
