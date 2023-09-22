package com.projectManager.andromeda.persistence;

import com.projectManager.andromeda.domain.Product;
import com.projectManager.andromeda.domain.repository.ProductRepository;
import com.projectManager.andromeda.persistence.crud.ProductoCrudRepository;
import com.projectManager.andromeda.persistence.entity.Producto;
import com.projectManager.andromeda.persistence.mapper.productMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private productMapper mapper;
    @Autowired
    private ProductoCrudRepository productoCrudRepository;



    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts((prods)));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
