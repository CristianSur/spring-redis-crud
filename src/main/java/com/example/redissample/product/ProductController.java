package com.example.redissample.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

//    private final RedisTemplate<String, Object> template;

    private final ProductRepository productRepository;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductModel save(@RequestBody ProductModel productModel) {
        return productRepository.save(productModel);
    }

//    @PostMapping("/save2")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void save2(@RequestBody ProductModel productModel) {
//        template.opsForHash().put("Product", productModel.getId(), productModel);
//    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<ProductModel> getAll() {
        return productRepository.findAll();
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam String id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductModel getById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }
}
