package be.intecbrussel.jdbcdemo.apps;

import be.intecbrussel.jdbcdemo.Data.BeerDao;
import be.intecbrussel.jdbcdemo.Data.BeerDaoListImp_ArrayList;
import be.intecbrussel.jdbcdemo.model.Beer;

import java.util.ArrayList;
import java.util.List;

public class JavaBeersCafeApp_ArrayList {

   // private List<Beer> beerDataBase = new ArrayList<>();

    public static void main(String[] args) {
        Beer beer = new Beer("primero supremo", 11.1,1.5,72);
        Beer beer1 = new Beer("primero supremo", 11.1,32,72);
       // JavaBeersCafeApp_ArrayList CafeApp = new JavaBeersCafeApp_ArrayList();
       // CafeApp.beerDataBase.add(beer);
       // CafeApp.beerDataBase.add(beer1);
       // CafeApp.beerDataBase.stream().forEach(System.out::println);

        BeerDaoListImp_ArrayList CafeApp = new BeerDaoListImp_ArrayList();
        CafeApp.deleteBeer(beer);
        CafeApp.createBeer(beer);
        CafeApp.createBeer(beer1);

        System.out.println(CafeApp.readBeer("primero supremo"));
        System.out.println(CafeApp.readBeer(42));

        Beer beer2 = CafeApp.readBeer(42);
        beer2.setStock(200);
        beer2.setPrice(4);
        CafeApp.updateBeer(beer2);
        System.out.println(CafeApp.readBeer(beer2.getId()));
    }
}
