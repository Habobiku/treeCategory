package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static com.company.Additional.createTree;
import static com.company.DataBase.dbConvert.convertTree;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category root=createTree();


    CategoryTest() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception
    {



    }

    @AfterEach
    void tearDown()
    {

    }

    @Test
    void changeName()
    {
        root.changeName(2,"NoteBook");

        String expected=root.findCategory(2).getName();
        String actual="NoteBook";
        Assert.assertEquals(expected,actual);
    }

    @Test
    void deleteCategory()
    {
        root.deleteCategory(2);
        var actual=root.findCategory(2);
        Assert.assertNull(actual);

    }

    @Test
    void addCategory()
    {
        root.addCategory("IPhone",12);
       String actual= root.findCategory(13).getName();
       String expected="IPhone";
       Assert.assertEquals(expected,actual);

    }

    @Test
    void sortCategory()
    {
        root.sortCategory(1);
       String actual= root.getChildren().get(0).getName();
       String expected="Phone";
        Assert.assertEquals(expected,actual);

    }
}