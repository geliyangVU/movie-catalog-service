package com.microservices_Geli.moviecatalogservice.resources;


import com.microservices_Geli.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieCatalogResource {

    public List<CatalogItem> getCatalog(String userId){
        return null;
    }
}
