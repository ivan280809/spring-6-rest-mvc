package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);
        log.debug(savedBeer.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @GetMapping()
    public List<Beer> listBeers(){
        log.debug("BeerController called");
        return beerService.listBeers();
    }

    @GetMapping(value ="/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("BeerController called");
        return beerService.getBeerById(beerId);
    }

}

