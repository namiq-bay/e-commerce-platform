package com.ecommerce.platform.product.service;

import com.ecommerce.platform.product.domain.MoneyTypes;
import com.ecommerce.platform.product.domain.Product;
import com.ecommerce.platform.product.domain.ProductImage;
import com.ecommerce.platform.product.domain.elastic.ProductES;
import com.ecommerce.platform.product.model.ProductSellerDTO;
import com.ecommerce.platform.product.model.product.ProductDTO;
import com.ecommerce.platform.product.model.product.ProductSaveRequest;
import com.ecommerce.platform.product.repository.elastic.ProductESRepository;
import com.ecommerce.platform.product.repository.mongo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ecommerce.platform.product.domain.ProductImage.ImageType;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductESRepository productESRepository;
    private final ProductRepository productRepository;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;
    private final ProductESService productESService;


    public Flux<ProductDTO> getAll() {
        return productESService.findAll().map(this::mapToDTO);
    }

    public ProductDTO save(ProductSaveRequest request) {
        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("PR001")
                .categoryId(request.getCategoryID())
                .companyId(request.getSellerID())
                .description(request.getDescription())
                .features(request.getFeatures())
                .name(request.getName())
                .price(request.getPrice())
                .productImage(request.getImages().stream()
                        .map(it -> new ProductImage(ImageType.FEATURE, it))
                        .collect(toList()))
                .build();
        product = productRepository.save(product).block();


        // 3 - Update on Redis
        return this.mapToDTO(productESService.saveNewProduct(product).block());

    }

    private ProductDTO mapToDTO(ProductES item) {
        if (item == null)
            return null;

        return ProductDTO.builder()
                // TODO client request
                .price(item.getPrice().get("USD"))
                .moneySymbol(MoneyTypes.USD.getSymbol())
                .name(item.getName())
                .features(item.getFeatures())
                .id(item.getId())
                .description(item.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(item.getId()))
                .categoryId(item.getCategory().getId())
                .available(productAmountService.getByProductId(item.getId()))
                .freeDelivery(productDeliveryService.checkFreeDelivery(item.getId(), item.getPrice().get("USD"), MoneyTypes.USD))
                .image(productImageService.getProductMainImage(item.getId()))
                .seller(ProductSellerDTO.builder().id(item.getSeller().getId()).name(item.getSeller().getName()).build())
                .build();
    }

    public Mono<Long> count() {
        return productRepository.count();
    }
}
