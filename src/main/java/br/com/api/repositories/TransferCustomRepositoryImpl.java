package br.com.api.repositories;

import br.com.api.models.Transfer;
import br.com.api.models.utils.CurrencyEnum;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TransferCustomRepositoryImpl implements TransferCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transfer> searchTransferCriteria(Integer id, Double amount, Date date, CurrencyEnum currency) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transfer> criteriaQuery = criteriaBuilder.createQuery(Transfer.class);

        Root<Transfer> root = criteriaQuery.from(Transfer.class);

        List<Predicate> predicates = new ArrayList<>();

        if(id != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
        }
        if(amount != null) {
            predicates.add(criteriaBuilder.equal(root.get("amount"), amount));
        }
        if(date != null) {
            predicates.add(criteriaBuilder.equal(root.get("date"), date));
        }
        if(currency != null) {
            predicates.add(criteriaBuilder.equal(root.get("current"), currency));
        }

        criteriaQuery.where(criteriaBuilder.and( predicates.toArray(Predicate[]::new)));

        List<Transfer> transferTypedQuery = entityManager.createQuery(criteriaQuery).getResultList();

        return transferTypedQuery;
    }


    //    just to study
    public List<Transfer> searchTransferManual(Integer id, Double amount, Date date, CurrencyEnum currency) {

        String query = "select T from Transfer as T";
        String condition = " where ";

        if (id != null) {
            query += condition + "T.id = :id";
            condition = " and ";
        }
        if (amount != null) {
            query += condition + "T.amount = :amount";
            condition = " and ";
        }
        if (date != null) {
            query += condition + "T.date = :date";
            condition = " and ";
        }
        if (currency != null) {
            query += condition + "T.currency = :currency";
        }

        TypedQuery<Transfer> q = entityManager.createQuery(query, Transfer.class);

        if (id != null) {
            q.setParameter("id", id);
        }
        if (amount != null) {
            q.setParameter("amount", amount);
        }
        if (date != null) {
            q.setParameter("date", date);
        }
        if (currency != null) {
            q.setParameter("currency", currency);
        }

        return q.getResultList();
    }
}
