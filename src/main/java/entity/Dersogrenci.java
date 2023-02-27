package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Dersogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int devamsizlik;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "DERS_FK")) //foreign key'e isim vermek için.
    private Ders ders;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "OGRENCI_FK"))
    private Ogrenci ogrenci;

}
