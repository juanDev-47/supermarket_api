package com.projectManager.andromeda.persistence;

import com.projectManager.andromeda.domain.Purchase;
import com.projectManager.andromeda.domain.repository.PurchaseRepository;
import com.projectManager.andromeda.persistence.crud.CompraCrudRepository;
import com.projectManager.andromeda.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return null;
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return Optional.empty();
    }

    @Override
    public Purchase save(Purchase purchase) {
        return null;
    }
}
