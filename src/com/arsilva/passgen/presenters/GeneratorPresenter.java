package com.arsilva.passgen.presenters;

import com.arsilva.passgen.models.Generator;
import com.arsilva.passgen.views.IGeneratorView;

import java.lang.reflect.GenericSignatureFormatError;

public class GeneratorPresenter implements IGeneratorPresenter {

    IGeneratorView view;

    @Override
    public void attachView(IGeneratorView view) {
        this.view = view;
    }

    @Override
    public void generatePassword(int size, boolean hasUppercase, boolean hasLowercase, boolean hasNumbers, boolean hasSymbols) {

        Generator generator = new Generator();
        try {
            generator.configure(size, hasUppercase, hasLowercase, hasNumbers, hasSymbols);
            this.view.showGeneratedPassword(generator.generate());
        } catch (Exception e) {
            this.view.showErrorMessage(e.getMessage());
        }
    }

}
