package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.pages.utils.NavigationUtils;
import com.solvd.pages.utils.PageUtils;

public class ToDoListBaseTest implements IAbstractTest {

    protected PageUtils pageUtils = new PageUtils();
    protected NavigationUtils navigationUtils =  new NavigationUtils();
    protected String expectedTaskText = "my task";
}
