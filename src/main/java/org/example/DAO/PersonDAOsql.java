package org.example.DAO;

import org.example.Model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOsql implements PersonDAO {
    private final Connection connection;

    public PersonDAOsql(Connection connection) {
        this.connection = connection;

    }

    @Override
    public Person create(Person person) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO person (first_name, last_name, email) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //statement.setInt(1, PersonIdSequencer.nextId());
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getEmail());
            statement.executeUpdate();
            connection.commit();


            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                person.setId(resultSet.getInt(1));
                return person;
            }

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person findById(int id) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE person_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Person> findByName(String name) {
        List<Person> result = new ArrayList<>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE first_name = ?");
            preparedStatement.setString(2, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add( new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                ));
            }

            return result;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person update (Person person) {
        try {

            connection.setAutoCommit(false);
            String sql = "UPDATE person SET first_name = ?, last_name = ?, email = ? WHERE person_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getEmail());
            statement.setInt(4, person.getId());
            statement.executeUpdate();
            connection.commit();
            return person;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            connection.setAutoCommit(false);
            String sql = "DELETE FROM person WHERE person_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            connection.commit();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public Collection<Person> findAll() {
        List<Person> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            while (resultSet.next()) {
                Person person = new Person(
                        resultSet.getInt("person_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                );

                result.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

}
