package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BeerService {

    void updateBeerById(UUID beerId, Beer beer);
    Beer getBeerById(UUID beerId);
     List<Beer> listBeers();

    Beer saveNewBeer(Beer beer);
}
