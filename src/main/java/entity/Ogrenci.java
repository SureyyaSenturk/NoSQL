package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Ogrenci  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String ogrenciAd;
    private String soyad;
    private int okulNo;
    private int yas;

    @OneToMany(mappedBy = "ogrenci",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Dersogrenci> dersOgrenciler;

}
