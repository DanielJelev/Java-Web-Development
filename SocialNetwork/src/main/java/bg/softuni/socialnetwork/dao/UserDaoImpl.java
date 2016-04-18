package bg.softuni.socialnetwork.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.softuni.socialnetwork.entity.UserProfile;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;


	@Override
	public UserProfile getUser(String username) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserProfile> criteriaQuery = criteriaBuilder.createQuery(UserProfile.class);
		Root<UserProfile> from = criteriaQuery.from(UserProfile.class);

		criteriaQuery.where(from.get("username").in(username));

		criteriaQuery.select(from);
		TypedQuery<UserProfile> query = entityManager.createQuery(criteriaQuery);
		List<UserProfile> users = query.getResultList();

		return users != null ? users.get(0) : null;
	}

	@Override
	public List<UserProfile> getUsers(String username) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserProfile> criteriaQuery = criteriaBuilder.createQuery(UserProfile.class);
		Root<UserProfile> from = criteriaQuery.from(UserProfile.class);

		Predicate predicate1 = criteriaBuilder.and();
		Predicate predicate2 = criteriaBuilder.and();
		
		if (username != null && !username.isEmpty()) {
			predicate2 = from.get("username").in(username);
		}

		criteriaQuery.where(predicate1, predicate2);

		criteriaQuery.select(from);
		TypedQuery<UserProfile> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();

}

	@Override
	@Transactional
	public boolean addUser(UserProfile user) {
	    entityManager.persist(user);
	    return true;
	}

	@Override
	public List<UserProfile> getFriends() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserProfile> criteriaQuery = criteriaBuilder.createQuery(UserProfile.class);
		Root<UserProfile> from = criteriaQuery.from(UserProfile.class);

		criteriaQuery.select(from);
		TypedQuery<UserProfile> query = entityManager.createQuery(criteriaQuery);
		List<UserProfile> users = query.getResultList();

		return users != null ? users : null;
		
	}

	@Override
	public UserProfile getUserById(Long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserProfile> criteriaQuery = criteriaBuilder.createQuery(UserProfile.class);
		Root<UserProfile> from = criteriaQuery.from(UserProfile.class);

		criteriaQuery.where(from.get("id").in(id));

		criteriaQuery.select(from);
		TypedQuery<UserProfile> query = entityManager.createQuery(criteriaQuery);
		List<UserProfile> users = query.getResultList();

		return users != null ? users.get(0) : null;
	}
}