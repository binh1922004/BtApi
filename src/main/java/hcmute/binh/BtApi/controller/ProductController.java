package hcmute.binh.BtApi.controller;

import hcmute.binh.BtApi.entity.Product;
import hcmute.binh.BtApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // API: Lấy sản phẩm theo danh mục
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

    // API: Lấy 10 sản phẩm bán chạy nhất
    @GetMapping("/top-selling")
    public ResponseEntity<List<Product>> getTopSellingProducts() {
        return ResponseEntity.ok(productService.getTop10BestSellingProducts());
    }

    // API: Lấy 10 sản phẩm được tạo trong vòng 7 ngày qua
    @GetMapping("/recent")
    public ResponseEntity<List<Product>> getRecentProducts() {
        return ResponseEntity.ok(productService.getRecentProducts());
    }
}

