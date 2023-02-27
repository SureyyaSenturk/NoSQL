package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Ders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String dersAdi;
    private String dersKodu;
    @OneToMany(mappedBy ="ders",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
//@ToString.Exclude  //Data anatasyonu kullanıldığı için tekrar kullanmaya gerek yok. Data anatasyonu içerisinde barındırır.
    private Set<Konu> konular;

    @OneToMany(mappedBy ="ders",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Dersogrenci> dersOgrenciler;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "OGRETMEN_FK"))
    private Ogretmen ogretmen;

}


