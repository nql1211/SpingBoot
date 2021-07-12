package com.ifisolution.project1.service;

import com.ifisolution.project1.entity.LineItems;
import com.ifisolution.project1.repository.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineItemService {
    private final LineItemRepository itemRepository;

    @Autowired
    public LineItemService(LineItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<LineItems> getItem(){
        return itemRepository.findAll();
    }

    public void addItem(LineItems items){
        itemRepository.save(items);
    }

    public void deleteItem(Long id){
        itemRepository.findById(id);
        boolean exist = itemRepository.existsById(id);
        if (!exist){
            throw new IllegalStateException("Not exist");
        }
        itemRepository.deleteById(id);
    }
}
