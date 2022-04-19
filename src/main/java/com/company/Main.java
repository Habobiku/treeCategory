package com.company;

import static com.company.Additional.createTree;
import static com.company.Additional.printTree;
import static com.company.DataBase.dbConvert.convertTree;
public class Main
{


    public static void main(String[] args) throws Exception
    {
        Category root=convertTree();
        root.sortCategory(1);
        printTree(root," ");
       // System.out.println(root.renderAsJson());

    }
}


//        Category root = createTree();
//       root.sortCategory(6);
//        printTree(root," ");