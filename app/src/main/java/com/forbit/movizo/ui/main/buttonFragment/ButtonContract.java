package com.forbit.movizo.ui.main.buttonFragment;

import com.forbit.movizo.model.Category;

import java.util.List;

public interface ButtonContract {

    interface Presenter{
        void getAllCategories();
    }

    interface View{
        void renderCategory(List<Category> categoryList);
        void catClick(Category category);
    }
}
