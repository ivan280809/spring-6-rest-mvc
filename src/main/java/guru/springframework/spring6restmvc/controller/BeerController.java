package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
@Slf4j
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID beerId){
        log.debug("BeerController called");
        return beerService.getBeerById(beerId);
    }

}

