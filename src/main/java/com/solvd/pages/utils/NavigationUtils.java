package com.solvd.pages.utils;

import com.solvd.consts.TaskCategory;
import com.solvd.pages.base.BottomMenuPageBase;
import com.solvd.pages.base.TasksPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class NavigationUtils implements ICustomTypePageFactory, IMobileUtils {

    public void open(NavigationOption navOpt) {
        BottomMenuPageBase bottomMenuPage = initPage(BottomMenuPageBase.class);
        switch (navOpt) {
            case TASKS -> {
                bottomMenuPage.clickTasksBtn();
            }
            case CALENDAR -> {
                bottomMenuPage.clickCalendarBtn();
            }
            case MENU -> {
                bottomMenuPage.clickMenuBtn();
            }
            case TASKS_ALL -> {
                bottomMenuPage.clickTasksBtn().clickTaskCategoryLabel(TaskCategory.ALL);
            }
            case TASKS_WORK -> {
                bottomMenuPage.clickTasksBtn().clickTaskCategoryLabel(TaskCategory.WORK);
            }
            case TASKS_PERSONAL -> {
                bottomMenuPage.clickTasksBtn().clickTaskCategoryLabel(TaskCategory.PERSONAL);
            }
            case TASKS_WISHLIST -> {
                bottomMenuPage.clickTasksBtn().clickTaskCategoryLabel(TaskCategory.WISHLIST);
            }
            case TASKS_BIRTHDAY -> {
                TasksPageBase tasksPage = bottomMenuPage.clickTasksBtn();
                tasksPage.swipeToTaskCategory(TaskCategory.BIRTHDAY.getName(), Direction.LEFT);
                tasksPage.clickTaskCategoryLabel(TaskCategory.BIRTHDAY);
            }
            default -> throw new IllegalStateException("Unexpected value for navigation option: " + navOpt);
        }
    }
}
