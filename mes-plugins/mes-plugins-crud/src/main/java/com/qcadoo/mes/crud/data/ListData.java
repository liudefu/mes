package com.qcadoo.mes.crud.data;

import java.util.List;

import com.qcadoo.mes.core.api.Entity;

public class ListData {

    private int totalNumberOfEntities;

    private List<Entity> entities;

    public ListData(int totalNumberOfEntities, List<Entity> entities) {
        this.totalNumberOfEntities = totalNumberOfEntities;
        this.entities = entities;
    }

    public int getTotalNumberOfEntities() {
        return totalNumberOfEntities;
    }

    public void setTotalNumberOfEntities(int totalNumberOfEntities) {
        this.totalNumberOfEntities = totalNumberOfEntities;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

}
