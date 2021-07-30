package br.com.api.repositories;

import br.com.api.models.Client;
import br.com.api.models.Transfer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientCustomRepositoryImpl implements ClientCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> searchClientCriteria(Integer id, String name, String lastName) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);

        Root<Client> root = criteriaQuery.from(Client.class);

        List<Predicate> predicates = new ArrayList<>();

        if (id != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
        }
        if (name != null) {
            predicates.add(criteriaBuilder.equal(root.get("name"), name));
        }
        if (lastName != null) {
            predicates.add(criteriaBuilder.equal(root.get("date"), lastName));
        }

        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(Predicate[]::new)));

        List<Client> clientTypedQuery = entityManager.createQuery(criteriaQuery).getResultList();

        return clientTypedQuery;
    }
}
