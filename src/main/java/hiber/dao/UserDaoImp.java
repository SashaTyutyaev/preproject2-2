package hiber.dao;

import hiber.model.User;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCar(String model, Integer series) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from User u where u.car.model = :model and u.car.series = :series");

        query.setParameter("model", model);
        query.setParameter("series", series);

        return (User) query.getSingleResult();
    }

}
