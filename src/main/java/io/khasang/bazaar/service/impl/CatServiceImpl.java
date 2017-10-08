package io.khasang.bazaar.service.impl;

import io.khasang.bazaar.dao.CatDao;
import io.khasang.bazaar.entity.Cat;
import io.khasang.bazaar.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("catService")
public class CatServiceImpl implements CatService {
    @Autowired
    private CatDao catDao;

    @Override
    public List<Cat> getList() {
        return catDao.getList();
    }

    @Override
    public List<Cat> getCatsByName(String name) {
        return catDao.getCatsByName(name);
    }

    @Override
    public Cat deleteCat(Long id) {
        Cat cat = catDao.getById(id);
        return catDao.delete(cat);
    }

    @Override
    public Cat addCat(Cat cat) {
        return catDao.add(cat);
    }

    @Override
    public Cat updateCat(Cat cat) {
        return catDao.update(cat);
    }

    @Override
    public Cat getById(Long id) {
        return catDao.getById(id);
    }
}
