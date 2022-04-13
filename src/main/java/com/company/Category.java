package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Category
{
    private int  id;
    private Category parent=null;
    private String name;
    private final List<Category> children=new ArrayList<>();

    public Category(String name,int id)
    {
        this.id=id;
        this.name=name;
    }
//base


    private int getMaxID()
    {
        int maxID=id;
        int temp;
        for (Category each:getChildren())
        {
            temp=each.getMaxID();
            if(temp>maxID)
                maxID=temp;
        }
        return maxID;


    }
    public int getID()
    {
            return id;
    }
    public String getName()
    {
        return name;
    }
    public List<Category> getChildren()
    {
        return children;
    }
    private void setID()
    {
        int i = getMaxID();
        this.id=++i;
    }

    public void changeName(int id,String name)
    {
        findCategory(id).name=name;

    }

    public void setParent(Category parent)
    {
        this.parent=parent;
    }
    public Category getParent()
    {
        return parent;
    }
    public Category findCategory(int id)
    {
            if (this.id == id)
                return this;

        for(Category each : this.getChildren())
        {
            var l=each.findCategory(id);
            if(l!=null)
                return l;

        }
            return null;
    }

    public Category addChild(Category child)
    {
        child.setParent(this);

        this.children.add(child);

        return child;
    }

    public void addChildren(List<Category> children,int id)
    {
      var current= findCategory(id);
        children.forEach(each->each.setParent(current));
        current.children.addAll(children);
    }
    public Category getRoot()
    {
        if(parent==null)
            return this;

        return parent.getRoot();
    }
    public void deleteCategory(int id)
    {
        var current=findCategory(id);
        if (current.parent != null)
        {
            int index = current.parent.getChildren().indexOf(current);
            current.parent.getChildren().remove(current);
            for (Category each : current.getChildren())
            {
                each.setParent(current.parent);
            }
            current.parent.getChildren().addAll(index, current.getChildren());
        }
        else
        {
            deleteRoot();
        }
        current.getChildren().clear();
    }

    private Category deleteRoot()
    {
        if (parent != null) {
            throw new IllegalStateException("deleteRoot not called on root");
        }
       Category newParent = null;
        if (!getChildren().isEmpty()) {
            newParent = getChildren().get(0);
            newParent.setParent(null);
            getChildren().remove(0);
            for (Category each : getChildren()) {
                each.setParent(newParent);
            }
            newParent.getChildren().addAll(getChildren());
        }
        this.getChildren().clear();
        return newParent;
    }

    public void addCategory(String name,int id)
    {
        int i=getMaxID();
        findCategory(id).addChild(new Category(name,++i));
    }

    public void sortCategory(int id)
    {
        if(this.parent==null) {
            Collections.reverse(children);
        }
        else
        {
            Collections.reverse(findCategory(id).children);
        }

    }
    public String toJson()
    {
        StringBuilder json = new StringBuilder("\"name\": \""+this.name+ "\", \"id\": \""+this.id+ "\"");

        return json.toString();

    }
    public String renderAsJson()
    {
        StringBuilder json = new StringBuilder("{\"name\": \""+this.name+ "\", \"id\": \""+this.id+ "\"");
        if(parent!=null)
            json.append(",\"parent\":{"+this.renderParentAsJson()+"}");
        if (this.children.size() > 0)
            json.append(", \"children\":[" + this.renderChildrenAsJson() + "]");



        json.append(" } ");
        return json.toString();

    }
    private String renderChildrenAsJson() {
        return this.children
                .stream()
                .map(Category::renderAsJson)
                .collect(Collectors.joining(","));
    }
    private String renderParentAsJson() {
        return this.parent.toJson();

    }


    


}



