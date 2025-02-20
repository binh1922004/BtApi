package hcmute.binh.BtApi.repository;

import hcmute.binh.BtApi.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // Tìm sản phẩm theo danh mục
    List<Product> findByCategoryId(String categoryId);

    // Tìm 10 sản phẩm bán chạy nhất (dựa trên số lượng trong OrderDetail)
    @Query("SELECT p FROM Product p JOIN OrderDetail od ON p.id = od.product.id GROUP BY p.id ORDER BY SUM(od.quantity) DESC")
    List<Product> findTop10BestSelling(Pageable pageable);

    // Tìm 10 sản phẩm tạo trong vòng 7 ngày qua
    @Query("SELECT p FROM Product p WHERE p.createDate >= :sevenDaysAgo ORDER BY p.createDate DESC")
    List<Product> findTop10RecentProducts(@Param("sevenDaysAgo") LocalDate sevenDaysAgo, Pageable pageable);
}
