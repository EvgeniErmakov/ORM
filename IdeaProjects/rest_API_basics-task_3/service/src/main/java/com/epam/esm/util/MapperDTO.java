package com.epam.esm.util;

import com.epam.esm.dto.*;
import com.epam.esm.entity.Certificate;
import com.epam.esm.entity.Order;
import com.epam.esm.entity.QuerySpecification;
import com.epam.esm.entity.Tag;
import com.epam.esm.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperDTO {

    private final ModelMapper mapper;

    public CertificateDTO convertCertificateToDTO(Certificate certificate) {
        return mapper.map(certificate, CertificateDTO.class);
    }

    public Certificate convertDTOToCertificate(CertificateDTO certificateDTO) {
        return mapper.map(certificateDTO, Certificate.class);
    }

    public QuerySpecification convertDTOToQuery(ParametersSpecificationDTO querySpecificationDTO) {
        return mapper.map(querySpecificationDTO, QuerySpecification.class);
    }

    public TagDTO convertTagToDTO(Tag tag) {
        return mapper.map(tag, TagDTO.class);
    }

    public Tag convertDTOToTag(TagDTO tagDTO) {
        return mapper.map(tagDTO, Tag.class);
    }

    public UserDTO convertUserToDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

    public OrderDTO convertOrderToDTO(Order order) {
        return mapper.map(order, OrderDTO.class);
    }

    public Order convertDTOToOrder(OrderDTO orderDTO) {
        return mapper.map(orderDTO, Order.class);
    }

    public Certificate convertPatchDTOToCertificate(PatchDTO patchDTO) {
        return mapper.map(patchDTO, Certificate.class);
    }
}
