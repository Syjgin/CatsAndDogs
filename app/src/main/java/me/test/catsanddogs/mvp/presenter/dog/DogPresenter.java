package me.test.catsanddogs.mvp.presenter.dog;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.interactor.BaseInteractor;
import me.test.catsanddogs.interactor.DogInteractor;
import me.test.catsanddogs.mvp.presenter.base.BaseListPresenterImplementation;

public class DogPresenter extends BaseListPresenterImplementation {

    @Override
    protected BaseInteractor getInteractor() {
        return new DogInteractor();
    }

    @Override
    protected int getIndex() {
        return Constants.DogIndex;
    }
}
