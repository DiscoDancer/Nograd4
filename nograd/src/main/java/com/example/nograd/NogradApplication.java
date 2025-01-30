package com.example.nograd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NogradApplication {

    private static final ProductRepository productRepository = new ProductRepository();

    public static void main(String[] args) {

        SpringApplication.run(NogradApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/getProducts")
    public String getProducts() {
        var sb = new StringBuilder();
        productRepository.findAll().forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }

    @GetMapping("/getProductByName")
    public String getProductByName(@RequestParam(value = "name") String name) {
        return productRepository.findByName(name).map(Product::toString).orElse("Product not found");
    }
}
