package com.epam.esm.service;

import com.epam.esm.dto.OrderDTO;
import com.epam.esm.entity.Page;

import java.util.List;

public interface OrderService extends CommonService<OrderDTO, Long> {

    List<OrderDTO> findAllOrdersByUserId(Long id, Page page);
}
