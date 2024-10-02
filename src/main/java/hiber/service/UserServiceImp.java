package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        log.info("Successfully add user with id {}", user.getId());
        userDao.add(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        List<User> users = userDao.listUsers();
        log.info("Users list size - {}", users.size());
        return users;
    }

    @Override
    @Transactional
    public User getUserByCar(String model, Integer series) {
        log.info("Successfully get user by car model - {}, series - {}", model, series);
        return userDao.getUserByCar(model, series);
    }

}
