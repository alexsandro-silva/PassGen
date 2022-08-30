package com.arsilva.passgen.presenters;

import com.arsilva.passgen.views.IGeneratorView;

public interface IGeneratorPresenter {

    void attachView(IGeneratorView view);
    void generatePassword(int size, boolean hasUppercase, boolean hasLowercase, boolean hasNumbers, boolean hasSymbols);
}
