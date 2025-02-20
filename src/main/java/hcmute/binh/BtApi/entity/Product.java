package hcmute.binh.BtApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private double price;
    private LocalDate createDate;

    @ManyToOne
    private Category category;
}
