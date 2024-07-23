package id.co.technicaltest.datakendaraan.repos.specs;

import org.springframework.data.jpa.domain.Specification;

import id.co.technicaltest.datakendaraan.entities.DataEntity;
import id.co.technicaltest.datakendaraan.models.DataModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class DataSpec implements Specification<DataEntity> {

    private final DataModel dataModel;

    public DataSpec(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public Predicate toPredicate(Root<DataEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        Predicate p = cb.conjunction(); // Use conjunction to initialize an "AND" predicate

        if (dataModel.getNomorRegistrasiKendaraan() != null && !dataModel.getNomorRegistrasiKendaraan().isEmpty()) {
            p = cb.and(p, cb.equal(root.get("nomorRegistrasiKendaraan"), dataModel.getNomorRegistrasiKendaraan()));
        }

        if (dataModel.getNamaPemilik() != null && !dataModel.getNamaPemilik().isEmpty()) {
            p = cb.and(p, cb.like(cb.lower(root.get("namaPemilik")),
                    "%" + dataModel.getNamaPemilik().toLowerCase() + "%"));
        }


        return p;
    }
}
