package be.intecbrussel.jdbcdemo.Data;

import be.intecbrussel.jdbcdemo.model.Beer;

public interface BeerDao {

    void createBeer(Beer beer);
    Beer readBeer(String beerName);
    Beer readBeer(int beerId);
    void updateBeer(Beer beer);
    void deleteBeer(Beer beer);

}
