package bg.softuni.socialnetwork.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.softuni.socialnetwork.entity.Post;
import bg.softuni.socialnetwork.entity.UserProfile;
@Repository
public class PostDaoImpl implements PostDao {
	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	@Override
	public List<Post> getAllPostForUser(Long userId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> from = criteriaQuery.from(Post.class);

		criteriaQuery.where(from.get("userId").in(userId));

		criteriaQuery.select(from);
		TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
		List<Post> posts = query.getResultList();

		return posts != null ? posts: null;
	}

	@Override
	@Transactional
	public boolean addPost(Post post) {
		entityManager.persist(post);
		return true;
	}

	@Override
	public List<Post> getAllPost() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> from = criteriaQuery.from(Post.class);

		criteriaQuery.select(from);
		TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
		List<Post> posts = query.getResultList();

		return posts != null ? posts : null;
	}

	@Override
	public Post getPostById(Long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
		Root<Post> from = criteriaQuery.from(Post.class);

		criteriaQuery.where(from.get("id").in(id));

		criteriaQuery.select(from);
		TypedQuery<Post> query = entityManager.createQuery(criteriaQuery);
		List<Post> posts = query.getResultList();

		return posts != null ? posts.get(0): null;
	}

	@Override
	@Transactional
	public boolean deletePost(Post post) {
		
//		Query query = entityManager.createNativeQuery("DELETE FROM POSTS WHERE ID = " + post.getId());
//		query.executeUpdate();
		entityManager.getTransaction().begin();
		entityManager.remove(post);
		entityManager.getTransaction().commit();
		return true;
	}

}
