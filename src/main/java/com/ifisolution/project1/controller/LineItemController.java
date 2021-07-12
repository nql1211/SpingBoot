package com.ifisolution.project1.controller;

import com.ifisolution.project1.entity.LineItems;
import com.ifisolution.project1.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line-items")
public class LineItemController {
    private final LineItemService itemService;

    @Autowired
    public LineItemController(LineItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<LineItems> getItem(){
        return itemService.getItem();
    }

    @PostMapping
    public void addNewLineItem(LineItems lineItems){
        itemService.addItem(lineItems);
    }

    @DeleteMapping
    public void deleteLineItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
    }
}
