package be.intecbrussel.jdbcdemo.apps;

import be.intecbrussel.jdbcdemo.Data.BeerDao;
import be.intecbrussel.jdbcdemo.Data.BeerDaoListImp;
import be.intecbrussel.jdbcdemo.model.Beer;


public class JavaBeersCafeApp {

    public static void main(String[] args) {
        Beer beer = new Beer("primero supremo", 11.1,1.5,72);
        Beer beer1 = new Beer("primero supremo", 11.1,32,72);

        BeerDaoListImp CafeApp = new BeerDaoListImp();
        System.out.println(CafeApp.readBeer("primero supremo"));
        System.out.println(CafeApp.readBeer(42));
        Beer beer2 = CafeApp.readBeer(42);
        beer2.setStock(200);
        beer2.setPrice(4);
        CafeApp.updateBeer(beer2);
        System.out.println(CafeApp.readBeer(beer2.getId()));
    }
}
