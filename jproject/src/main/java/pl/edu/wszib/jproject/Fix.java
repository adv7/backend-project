package pl.edu.wszib.jproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Fixes")
public class Fix {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="thing", nullable = false)
    private String thing;
    @Column(name = "date", nullable = false)
    private String stringDate;
    @Column(name = "price", nullable = false)
    private float price;
}
