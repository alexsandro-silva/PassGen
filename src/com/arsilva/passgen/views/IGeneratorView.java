package com.arsilva.passgen.views;

public interface IGeneratorView {

    void showGeneratedPassword(String password);
    void showErrorMessage(String message);
}
