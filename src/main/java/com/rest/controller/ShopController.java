package com.rest.controller;

import com.rest.model.Shop;
import com.rest.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController{

    @Autowired
    private ShopService shopService;

    @RequestMapping(value="/saveShop", method=RequestMethod.POST)
    @ResponseStatus(code=HttpStatus.CREATED)
    public void saveShop(@RequestBody Shop shop){
        shopService.save(shop);
    }

    @GetMapping("/findShop")
    public ResponseEntity<Shop> findById(@RequestParam int id){
        Shop shop=shopService.findById(id);
        if(shop != null){
            return ResponseEntity.ok(shop);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAllShop")
    public ResponseEntity<List<Shop>> findAllShops(){
        List<Shop> shops=shopService.findAllShop();
        if(shops != null)
            return ResponseEntity.ok(shops);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteShop/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShop(@PathVariable int id){
        shopService.deleteById(id);

    }

    @PutMapping("/replaceShop/{id}")
    public ResponseEntity<Shop> replaceShop(@RequestBody Shop shop, @PathVariable Integer id){
        Shop replacedShop=shopService.replaceShop(shop, id);
        if(replacedShop != null)
            return ResponseEntity.ok(replacedShop);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/findArea")
    public ResponseEntity<List<String>> findArea(){
        List<String> findArea=shopService.findArea();
        return ResponseEntity.ok(findArea);
    }

    @GetMapping("/findShopAreaDiscount")
    public ResponseEntity<List<String>> findShopAreaDiscount(){
        List<String> findShopAreaDiscount=shopService.findShopAreaDiscount();
        return ResponseEntity.ok(findShopAreaDiscount);
    }


}
