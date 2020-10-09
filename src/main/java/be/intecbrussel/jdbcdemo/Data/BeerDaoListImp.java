package be.intecbrussel.jdbcdemo.Data;

import be.intecbrussel.jdbcdemo.model.Beer;

import java.sql.*;

public class BeerDaoListImp implements BeerDao{

    public final String connectionString = "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC";
    public final String username = "root";
    public final String password = "root";

    @Override
    public void createBeer(Beer beer) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
              // do database things
            PreparedStatement statement = connection.prepareStatement("insert into beers(name, alcohol, price, stock) value (?,?,?,?)");
            statement.setString(1,beer.getBeerName());
            statement.setDouble(2,beer.getAlcoholPercentage());
            statement.setDouble(3,beer.getPrice());
            statement.setInt(4,beer.getStock());

            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public Beer readBeer(String beerName) {
        Beer readedBeer = new Beer();

        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
            // ask for a statement
            Statement  stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM beers where name like '" + beerName + "'");
            if(result.next()){
                readedBeer.setId(result.getInt("id"));
                readedBeer.setBeerName(result.getString("name"));
                readedBeer.setAlcoholPercentage(result.getDouble("alcohol"));
                readedBeer.setPrice(result.getDouble("price"));
                readedBeer.setStock(result.getInt("stock"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return readedBeer;
    }

    @Override
    public Beer readBeer(int beerId) {

        Beer readedBeer = new Beer();

        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
            // ask for a statement
            Statement  stm = connection.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM beers where id like " + beerId );
            if(result.next()){
                readedBeer.setId(result.getInt("id"));
                readedBeer.setBeerName(result.getString("name"));
                readedBeer.setAlcoholPercentage(result.getDouble("alcohol"));
                readedBeer.setPrice(result.getDouble("price"));
                readedBeer.setStock(result.getInt("stock"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return readedBeer;
    }

    @Override
    public void updateBeer(Beer beer) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {

            // do database things
            PreparedStatement statement = connection.prepareStatement("update beers set name=?, alcohol=?, price=?, stock=? where id = ?");
            statement.setInt(5,beer.getId());
            statement.setString(1,beer.getBeerName());
            statement.setDouble(2,beer.getAlcoholPercentage());
            statement.setDouble(3,beer.getPrice());
            statement.setInt(4,beer.getStock());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteBeer(Beer beer) {
        try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
            PreparedStatement statement = connection.prepareStatement("delete from beers where name like '" + beer.getBeerName() + "'");
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
