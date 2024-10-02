package hiber.dao;

import hiber.model.Car;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CarDaoImpl implements CarDao {

    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> getCars(int limit) {
        Query<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        query.setMaxResults(limit);
        return query.getResultList();
    }

}
