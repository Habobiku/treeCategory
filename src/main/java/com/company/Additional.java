package com.company;

public class Additional
{
    public static void printTree(Category node, String appender)
    {
        System.out.println(appender + node.getName()+"("+(node.getID())+")");
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }
    public static Category createTree() {
        int id=1;

        Category root = new Category("root",id++);
        Category node1 = root.addChild(new Category("Laptops",id++));

        Category node11 = node1.addChild(new Category("Acer",id++));
        Category node111 = node11.addChild(new Category("Nitro",id++));

        Category node12 = node1.addChild(new Category("Apple",id++));
        Category node121 = node12.addChild(new Category("MacBook",id++));

        Category node2 = root.addChild(new Category("Game Console",id++));
        Category node21 = node2.addChild(new Category("Playstation",id++));
        Category node211 = node21.addChild(new Category("Pro",id++));

        Category node22 = node2.addChild(new Category("Xbox",id++));
        Category node221 = node22.addChild(new Category("One",id++));

        Category node3 = root.addChild(new Category("Phone",id++));

        return root;
    }


}
