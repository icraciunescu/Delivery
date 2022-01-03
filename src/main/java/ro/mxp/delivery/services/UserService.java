package ro.mxp.delivery.services;

import ro.mxp.delivery.entities.User;

public interface UserService {

    User findUserByUsername(String username);

}
