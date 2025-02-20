package hcmute.binh.BtApi.service;


import hcmute.binh.BtApi.entity.Product;
import hcmute.binh.BtApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getTop10BestSellingProducts() {
        Pageable pageable = PageRequest.of(0, 10);
        return productRepository.findTop10BestSelling(pageable);
    }

    public List<Product> getRecentProducts() {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        return productRepository.findTop10RecentProducts(sevenDaysAgo, (Pageable) PageRequest.of(0, 10));
    }
}

