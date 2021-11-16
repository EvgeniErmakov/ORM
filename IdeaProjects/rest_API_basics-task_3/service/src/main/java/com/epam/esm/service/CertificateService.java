package com.epam.esm.service;

import com.epam.esm.dto.CertificateDTO;
import com.epam.esm.dto.PatchDTO;
import com.epam.esm.dto.QuerySpecificationDTO;
import com.epam.esm.entity.Page;

import java.util.List;

public interface CertificateService extends BaseService<CertificateDTO, Long> {

    List<CertificateDTO> findAll(QuerySpecificationDTO querySpecificationDTO, Page page);

    CertificateDTO update(CertificateDTO certificateDTO);

    CertificateDTO applyPatch(Long id, PatchDTO patchDTO);

    List<CertificateDTO> findAllByOrderId(Long id, Page page);
}
