package com.projectManager.andromeda.persistence.mapper;

import com.projectManager.andromeda.domain.Purchase;
import com.projectManager.andromeda.domain.PurchaseItem;
import com.projectManager.andromeda.persistence.entity.ComprasProducto;
import com.projectManager.andromeda.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {productMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    Purchase toPurchase(Producto producto);
    PurchaseItem toPurchaseItem(ComprasProducto producto);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}