package me.test.catsanddogs.mvp.presenter.cat;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.interactor.BaseInteractor;
import me.test.catsanddogs.interactor.CatInteractor;
import me.test.catsanddogs.mvp.presenter.base.BaseListPresenterImplementation;

public class CatPresenter extends BaseListPresenterImplementation {

    @Override
    protected BaseInteractor getInteractor() {
        return new CatInteractor();
    }

    @Override
    protected int getIndex() {
        return Constants.CatIndex;
    }
}
