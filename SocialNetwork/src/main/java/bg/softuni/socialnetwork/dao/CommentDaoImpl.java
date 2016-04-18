package bg.softuni.socialnetwork.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.softuni.socialnetwork.entity.Comment;
@Repository
public class CommentDaoImpl implements CommentDao {
	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	@Override
	public List<Comment> getAllCommentsForPost(Long postId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
		Root<Comment> from = criteriaQuery.from(Comment.class);

		criteriaQuery.where(from.get("postId").in(postId));

		criteriaQuery.select(from);
		TypedQuery<Comment> query = entityManager.createQuery(criteriaQuery);
		List<Comment> comemnts = query.getResultList();

		return comemnts != null ? comemnts: null;
	}

	@Override
	@Transactional
	public boolean addComment(Comment comment) {
		entityManager.persist(comment);
		return true;
	}

	@Override
	public List<Comment> getAllComments() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
		Root<Comment> from = criteriaQuery.from(Comment.class);

		criteriaQuery.select(from);
		TypedQuery<Comment> query = entityManager.createQuery(criteriaQuery);
		List<Comment> comments = query.getResultList();

		return comments != null ? comments : null;
	}

	@Override
	public Comment getComemntById(Long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Comment> criteriaQuery = criteriaBuilder.createQuery(Comment.class);
		Root<Comment> from = criteriaQuery.from(Comment.class);

		criteriaQuery.where(from.get("id").in(id));

		criteriaQuery.select(from);
		TypedQuery<Comment> query = entityManager.createQuery(criteriaQuery);
		List<Comment> comments = query.getResultList();

		return comments != null ? comments.get(0): null;
	}


}
