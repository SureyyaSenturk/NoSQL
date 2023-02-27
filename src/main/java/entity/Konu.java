package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Konu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String konuAd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "DERS_FK"))
    private Ders ders;

}
