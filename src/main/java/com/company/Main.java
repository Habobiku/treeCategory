package com.company;

import static com.company.DataBase.dbConvert.convertTree;
public class Main
{


    public static void main(String[] args) throws Exception
    {
        Category root=convertTree();
        System.out.println(root.renderAsJson());

    }
}


//        Category root = createTree();
//       root.sortCategory(6);
//        printTree(root," ");