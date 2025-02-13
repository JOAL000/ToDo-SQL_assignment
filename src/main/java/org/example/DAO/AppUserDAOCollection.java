package org.example.DAO;

import org.example.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserDAOCollection implements AppUserDAO {
    private final List<AppUser> appUsers;

    public AppUserDAOCollection() {
        this.appUsers = new ArrayList<>();
    }

    @Override
    public AppUser persist(AppUser appUser) {
        appUsers.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUsers.stream()
                .filter(appUser -> appUser.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(String username) {
        appUsers.removeIf(appUser -> appUser.getUsername().equals(username));
    }

}


