package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.OrderLineCreateRequest;
import com.anup.ecommerce.dto.response.OrderLineResponse;
import com.anup.ecommerce.entity.OrderLine;
import com.anup.ecommerce.mapper.OrderLineMapper;
import com.anup.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public Integer saveOrderLine(OrderLineCreateRequest orderLineCreateRequest) {
        OrderLine orderLine = OrderLineMapper.toEntity(orderLineCreateRequest);

        OrderLine savedOrderLine = orderLineRepository.save(orderLine);

        return savedOrderLine.getId();
    }

    public List<OrderLineResponse> getOrderLinesByOrderId(Integer orderId) {
        List<OrderLine> orderLines = orderLineRepository.findAllByOrderId(orderId);

        return OrderLineMapper.toResponse(orderLines);
    }
}
