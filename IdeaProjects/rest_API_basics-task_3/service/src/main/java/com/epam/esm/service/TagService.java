package com.epam.esm.service;

import com.epam.esm.dto.TagDTO;
import com.epam.esm.entity.Page;

import java.util.List;

public interface TagService extends CommonService<TagDTO, Long> {

    List<TagDTO> findAllByCertificateId(Long id, Page page);

    TagDTO findPopular();
}
