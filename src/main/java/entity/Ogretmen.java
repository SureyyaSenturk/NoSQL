package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Ogretmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ogretmenAd;
    private int yas;
    private String brans;
    private boolean idareciMi;

    @OneToMany(mappedBy = "ogretmen",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Ders> dersler;

}
