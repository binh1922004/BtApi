package hcmute.binh.BtApi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int quantity;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Orders orders;
}
