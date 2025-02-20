package hcmute.binh.BtApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private double totalPrice;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetails;
}
