package com.epam.esm.dao;

import com.epam.esm.entity.Certificate;
import com.epam.esm.entity.Page;
import com.epam.esm.entity.QuerySpecification;

import java.util.List;

public interface CertificateDAO extends BaseDAO<Certificate, Long> {

    List<Certificate> findAll(QuerySpecification querySpecification, Page page);

    Certificate update(Certificate certificate, Certificate update);

    Certificate applyPatch(Certificate certificate, Certificate update);
}
