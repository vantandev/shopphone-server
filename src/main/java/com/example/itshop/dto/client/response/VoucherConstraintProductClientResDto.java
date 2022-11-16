package com.example.itshop.dto.client.response;

import com.example.itshop.entities.Product;
import com.example.itshop.entities.VoucherConstraintProduct;
import com.example.itshop.entities.VoucherConstraintProductDetail;
import com.example.itshop.enums.VoucherConstraintProductType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class VoucherConstraintProductClientResDto {
	private Long id;
	
	private VoucherConstraintProductType constraintType;
	
	private Collection<Long> productIds;
	
	public VoucherConstraintProductClientResDto(VoucherConstraintProduct product) {
		this.id = product.getId();
		this.constraintType = product.getConstraintType();
		this.productIds = product.getVoucherConstraintProductDetails().stream()
			.map(VoucherConstraintProductDetail::getProduct)
			.map(Product::getId)
			.collect(Collectors.toList());
	}
}
