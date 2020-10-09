package be.intecbrussel.jdbcdemo.Data;

import be.intecbrussel.jdbcdemo.Data.BeerDao;
import be.intecbrussel.jdbcdemo.model.Beer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BeerDaoListImp_ArrayList implements BeerDao {

    private List<Beer> beerdb = new ArrayList<>();

    @Override
    public void createBeer(Beer beer) {
        beerdb.add(beer);
    }


    @Override
    public Beer readBeer(String beerName) {
            return beerdb.stream()
                        .filter(b -> b.getBeerName().equals(beerName))
                        .findFirst().get();
    }

    @Override
    public Beer readBeer(int beerId) {
        Beer beer = beerdb.get(beerId);
        return beer;
    }

    @Override
    public void updateBeer(Beer beer) {
       Optional<Beer> beerOptional = beerdb.stream().filter(b -> b.getBeerName().equals(beer.getBeerName()))
                                    .findFirst();
       if (beerOptional.isPresent()) {
           Beer beerToUpdate = beerOptional.get();
           beerToUpdate.setAlcoholPercentage(beer.getAlcoholPercentage());
           beerToUpdate.setStock(beer.getStock());
           beerToUpdate.setPrice(beer.getPrice());
       }
    }

    @Override
    public void deleteBeer(Beer beer) {
        beerdb.remove(beer);
    }
}
